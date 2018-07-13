#ABERTURA DE ARQUIVO TXT

$arquivo = "C:\\Users\\Mauricio\\Desktop\\Perl\\texto.txt";

open (INFO, $arquivo);
@linhas = <INFO>;
close(INFO);

for (@linhas){
	if(/teste/){
		print "Axei \n";
	}else{
		print "nao axei \n";
	}
}
print "\n\n\n";