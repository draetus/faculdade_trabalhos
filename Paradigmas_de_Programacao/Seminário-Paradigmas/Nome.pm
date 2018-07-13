#DECLARACAO DE CLASSES
package Nome;
use strict;

sub new
{
    my ( $class ) = shift;
    my $self = {
        _nome => shift,
        _sobrenome => shift
        };
    bless $self, $class;
    return $self;
}

sub alteraNome
{
    my ( $self, $nome ) = @_;
    $self->{ _nome }=$nome;
    return $self;
}

sub escreveNome
{
    my ( $self ) = @_;
    return $self->{ _nome };
}

sub escreveNomeCompleto
{
    my ( $self ) = @_;
    return ( uc $self->{_sobrenome} ).", ".$self->{_nome};
}

sub DESTROY
{
    
}

1;