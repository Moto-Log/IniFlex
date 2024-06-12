/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.iniflex.projetoiniflex;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author gabri
 */
public class ProjetoIniflex
{

    public static void main(String[] args)
    {
        List<Funcionario> funcionarios = new ArrayList<>();
        
        funcionarios.add(new Funcionario("Maria", LocalDate.of(2000, 1, 18), new BigDecimal(2009.44), "Operador"));
        funcionarios.add(new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal(2284.38), "Operador"));
        funcionarios.add(new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal(9836.14), "Coordenador"));
        funcionarios.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal(19119.88), "Diretor"));
        funcionarios.add(new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal(2234.68), "Recepcionista"));
        funcionarios.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal(1582.72), "Operador"));
        funcionarios.add(new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal(4071.84), "Contador"));
        funcionarios.add(new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal(3017.45), "Gerente"));
        funcionarios.add(new Funcionario("Heloisa", LocalDate.of(2003, 5, 24), new BigDecimal(1606.85), "Eletricista"));
        funcionarios.add(new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal(2799.93), "Gerente"));


        funcionarios.removeIf(funcionario -> funcionario.getNome().equals("João"));

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DecimalFormat decimalFormatter = new DecimalFormat("#,##0.00");

        System.out.println("Lista de funcionarios:");
        for (Funcionario f : funcionarios)
        {
            System.out.println(
                    f.getNome() +
                    " | " +
                    f.getDataNascimento().format(dateFormatter) +
                    " | " +
                    decimalFormatter.format(f.getSalario()) +
                    " | " +
                    f.getFuncao());
        }
        
        for (Funcionario f : funcionarios)
        {
            f.setSalario(f.getSalario().multiply(new BigDecimal(1.1)));
        }

        Map<String, List<Funcionario>> funcionariosFuncao = funcionarios.stream()
            .collect(Collectors.groupingBy(Funcionario::getFuncao));

        System.out.println("\nFuncionarios agrupados por funcao:");
        for (Map.Entry<String, List<Funcionario>> entry : funcionariosFuncao.entrySet())
        {
            System.out.println("Funcao: " + entry.getKey());
            for (Funcionario f : entry.getValue())
            {
                System.out.println(
                        " ->" +
                        f.getNome() +
                        " | " +
                        f.getDataNascimento().format(dateFormatter) +
                        " | " +
                        decimalFormatter.format(f.getSalario()));
            }
        }

        System.out.println("\nFuncionarios que fazem aniversario em outubro e dezembro:");
        for (Funcionario f : funcionarios)
        {
            int Aniversario = f.getDataNascimento().getMonthValue();
            if (Aniversario == 10 || Aniversario == 12)
            {
                System.out.println(
                        f.getNome() +
                        " | " +
                        f.getDataNascimento().format(dateFormatter) +
                        " | " +
                        decimalFormatter.format(f.getSalario()));
            }
        }
        
        Funcionario funcionarioMaisVelho = funcionarios.getFirst();
        for(Funcionario f : funcionarios)
        {
            if (f.getDataNascimento().isBefore(funcionarioMaisVelho.getDataNascimento())){
                funcionarioMaisVelho = f;
            }
        }
        
         int idade = Period.between(funcionarioMaisVelho.getDataNascimento(), LocalDate.now()).getYears();
         System.out.println(
                 "\nFuncionario com maior idade: " +
                         funcionarioMaisVelho.getNome() +
                         " | " +
                         idade +
                         " anos");


        System.out.println("\nFuncionarios em ordem alfabetica:");
        funcionarios.stream()
            .sorted(Comparator.comparing(Funcionario::getNome))
            .forEach(f ->
            {
                System.out.println(
                        f.getNome() +
                        " | " +
                        f.getDataNascimento().format(dateFormatter) +
                        " | " +
                        decimalFormatter.format(f.getSalario()) +
                        " | " +
                        f.getFuncao());
            });


        BigDecimal totalSalarios = new BigDecimal(0);
        
        funcionarios.forEach(f ->
        {
            totalSalarios.add(f.getSalario());
        });

        System.out.println(
                "\nTotal dos salarios: "+
                decimalFormatter.format(totalSalarios));

        BigDecimal salarioMinimo = new BigDecimal(1212.00);
        System.out.println("\nSalarios minimos por funcionario:");
        for (Funcionario f : funcionarios)
        {
            BigDecimal quantidadeSalariosMinimos = f.getSalario().divide(salarioMinimo, 2, BigDecimal.ROUND_HALF_UP);
            System.out.println(
                    f.getNome() +
                    " | " +
                    quantidadeSalariosMinimos +
                    " salarios minimos");
        }
    }
}
