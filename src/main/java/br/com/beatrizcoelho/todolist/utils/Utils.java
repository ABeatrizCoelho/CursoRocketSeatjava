package br.com.beatrizcoelho.todolist.utils;

import java.beans.PropertyDescriptor;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

public class Utils {


            public static void copyNonNullProperties(Object source, Object target){
//vai copiar tudo que n for nulo - source: onde ta indo target: onde vai

            BeanUtils.copyProperties(source, target, getNullPropertyNames(source)); //a gente consegue copiar as propriedades de um objeto pra um outro objeto
            //VAI PEGAR TUDO QUE EU TENHO DE PROPRIEDADE NULA, ele vai atribuir e converter pra gente ter a mescla das nossas informacoes
            }


    public static String[] getNullPropertyNames(Object source){
            //isso aqui de pegar todas as propriedades que estao com o valor nulo, vai servir pra fazer um copy do nosso objeto do repositorio pro objetdo do nosso body
        final BeanWrapper src = new BeanWrapperImpl(source);
         //interface que fornece uma forma da gente acessar as propriedades de um objeto dentro do java e o IMPL e a implementacao da interface

         PropertyDescriptor[] pds = src.getPropertyDescriptors();

         Set<String> emptyNames = new HashSet<>(); //vamos inserir dentro do empty name as informacoes

         for(PropertyDescriptor pd: pds){
            Object srcValue = src.getPropertyValue(pd.getName()); //vou pegar o meu getname e obter o valor da propriedade atual
            //eu vou verificar se ela e nula, se for, eu vou adicionar o nome dela dentro do meu conjunto
            if(srcValue == null){
                emptyNames.add(pd.getName());
            }
         }
         //agora vou criar, com esse meu emptynames, um array de string pra armazenar todos os nomes com essa minha propriedade
         String[] result = new String[emptyNames.size()];
         return emptyNames.toArray(result); //entao aqui ele vai converter o conjunto de nome das minhas propriedades pra um array de string
        }
    } 
