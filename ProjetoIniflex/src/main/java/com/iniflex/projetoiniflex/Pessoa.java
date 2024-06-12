package com.iniflex.projetoiniflex;

import java.time.LocalDate;
/**
 *
 * @author Gabriel Barros Guimarães
 */
public class Pessoa
{
    private String nome;
    private LocalDate dataNascimento;

    public Pessoa(String nome, LocalDate dataNascimento)
    {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public String getNome()
    {
        return nome;
    }

    public LocalDate getDataNascimento()
    {
        return dataNascimento;
    }
}
