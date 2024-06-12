/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iniflex.projetoiniflex;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 * @author Gabriel Barros Guimarães
 */
public class Funcionario extends Pessoa
{
    private String funcao;
    private BigDecimal salario;
    
    public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao)
    {
        super(nome, dataNascimento);
        this.salario = salario;
        this.funcao = funcao;
    }
    
    public String getFuncao()
    {
        return funcao;
    }
    
    public  BigDecimal getSalario() 
    {
        return salario;
    }
    
    public void setSalario(BigDecimal salario){
        this.salario = salario;
    }
}
