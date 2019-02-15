import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class WordCount {

  public static class TokenizerMapper
       extends Mapper<Object, Text, Text, Text>{

    private final static IntWritable one = new IntWritable(1);
    private Text word = new Text();
    private int sum = 0;
    

    public void map(Object key, Text value, Context context
                    ) throws IOException, InterruptedException {
      StringTokenizer itr = new StringTokenizer(value.toString());
      while (itr.hasMoreTokens()) {
        word.set(itr.nextToken());
        String filePathString = ((FileSplit) context.getInputSplit()).getPath().getName();
        Text t = new Text(filePathString+";1"+";"+Integer.toString(sum));
        sum += word.toString().length() + 1;
        context.write(word ,t);
      }
    }
  }

  public static class IntSumReducer
       extends Reducer<Text,Text,Text,Text> {
    private Text result = new Text();

    public void reduce(Text key, Iterable<Text> values,
                       Context context
                       ) throws IOException, InterruptedException {
        
      HashMap<String, Integer> maplivros = new HashMap<>();
      HashMap<String, String> mapposicoes = new HashMap<>();
      for (Text val : values) {
          String split[] = val.toString().split(";");
          for (int i=0; i<split.length; i+=3)
          {
              if (maplivros.containsKey(split[i]))
              {
                  int quant = maplivros.get(split[i]);
                  quant += Integer.parseInt(split[i+1]);
                  String pos = mapposicoes.get(split[i]);
                  pos += "," + split[i+2];
                  maplivros.put(split[i], quant);
                  mapposicoes.put(split[i], pos);
              }
              else
              {
                  maplivros.put(split[i], Integer.parseInt(split[i+1]));
                  mapposicoes.put(split[i],split[i+2]);
              }
          }
      }
      String saida = "";
      for (Iterator<String> it = maplivros.keySet().iterator(); it.hasNext(); )
      {
          String livro = it.next();
          saida += livro+";"+maplivros.get(livro)+";"+mapposicoes.get(livro)+";";
      }
      result.set(saida);
      context.write(key, result);
    }
  }

  public static void main(String[] args) throws Exception {
    Configuration conf = new Configuration();
    Job job = Job.getInstance(conf, "word count");
    job.setJarByClass(WordCount.class);
    
    job.setMapperClass(TokenizerMapper.class);
    job.setCombinerClass(IntSumReducer.class);
    job.setReducerClass(IntSumReducer.class);
    
    job.setOutputKeyClass(Text.class);
    job.setOutputValueClass(Text.class);
    
    //job.setNumReduceTasks(0);
    
    FileInputFormat.addInputPath(job, new Path(args[0]));
    FileOutputFormat.setOutputPath(job, new Path(args[1]));
    
    System.exit(job.waitForCompletion(true) ? 0 : 1);
  }
}