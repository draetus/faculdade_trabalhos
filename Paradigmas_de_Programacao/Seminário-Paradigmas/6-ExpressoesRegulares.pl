#EXPRESSÕES REGULARES

$sentenca = "la casa de papel";

if($sentenca =~ /casa/){ #MATCH
	$sentenca =~ s/casa/puerta/; #Substituição de 'casa' para 'porta';
	print $sentenca;
}else{
	print "nao axou";
}

print "\n\n\n";