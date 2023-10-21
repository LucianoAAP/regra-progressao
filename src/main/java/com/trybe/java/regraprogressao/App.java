package com.trybe.java.regraprogressao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * App.
 */
public class App {

  /**
   * Metodo main.
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in).useDelimiter("\\n");
    System.out.println("Digite a quantidade de atividades para cadastrar:");
    int numberOfActivities = scanner.nextInt();
    List<Activity> activities = new ArrayList<>();
    for (int index = 1; index <= numberOfActivities; index += 1) {
      System.out.println(String.format("Digite o nome da atividade %s:", index));
      String name = scanner.next();
      System.out.println(String.format("Digite o peso da atividade %s:", index));
      int weight = scanner.nextInt();
      System.out.println(String.format("Digite a nota obtida para %s:", name));
      int grade = scanner.nextInt();
      Activity activity = new Activity(name, weight, grade);
      activities.add(activity);
    }
    int weightSum = activities.stream().map(activity -> activity.getWeight())
        .reduce(0, (accumulator, current) -> accumulator + current);
    if (weightSum != 100) {
      System.out.println("A soma dos pesos é diferente de 100!");
      scanner.close();
      return;
    }
    double finalGrade = calculateFinalGrade(activities);
    if (finalGrade < 85) {
      System.out.println("Lamentamos informar que, com base na sua pontuação "
          + "alcançada neste período, " + finalGrade + "%, "
          + "você não atingiu a pontuação mínima necessária para sua aprovação.");
      scanner.close();
      return;
    }
    System.out.println("Parabéns! Você alcançou " + finalGrade + "%! E temos o prazer "
        + "de informar que você obteve aprovação!");
    scanner.close();
  }
  
  /**
   * Calcula a nota final.
   */
  private static double calculateFinalGrade(List<Activity> activities) {
    double finalGrade = 0;
    for (Activity activity : activities) {
      finalGrade += activity.getWeight() * activity.getGrade();
    }
    return finalGrade / 100;
  }
}