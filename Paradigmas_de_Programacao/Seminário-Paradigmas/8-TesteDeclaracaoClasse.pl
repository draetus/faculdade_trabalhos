#DECLARACAO DE CLASSES
use strict;
use Nome;

print "Digite seu nome : ";
my $n = <STDIN>;
print "Digite seu sobrenome : ";
my $s = <STDIN>;

chomp $n;
chomp $s;
my $a=Nome->new($n,$s);

print "\nOlá ".$a->escreveNomeCompleto()."!\n";
print "Ou devo usar apenas ".$a->escreveNome()."?\n\n";

exit 0;