package hr.fer.zemris.projekt.algorithms.neural.elman.ga;

import hr.fer.zemris.projekt.parameter.Parameter;
import hr.fer.zemris.projekt.parameter.ParameterType;
import hr.fer.zemris.projekt.parameter.Parameters;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by Dominik on 9.12.2016..
 */
public class GAParameters implements Parameters<GA> {
    private Set<Parameter> parameters = new HashSet<>();

    public static final String POPULATION_SIZE = "Population size";
    public static final int DEFAULT_POPULATION_SIZE = 50;

    public static final String MAX_GENERATIONS = "Max generations";
    public static final int DEFAULT_MAX_GENERATIONS = 1_000;

    public static final String TOURNAMENT_SIZE = "Tournament size";
    public static final int DEFAULT_TOURNAMENT_SIZE = 4;

    public static final String ALPHA = "Alpha";
    public static final double DEFAULT_ALPHA = 0.25;

    public static final String SIGMA = "Sigma";
    public static final double DEFAULT_SIGMA = 0.25;

    public static final String STOP_CONDITION = "Stop condition";
    public static final double DEFAULT_STOP_CONDITION = 1;

    public static final String MIN_STARTING_VALUE = "Minimal starting weights";
    public static final double DEFAULT_MINIMAL_WEIGHT = -0.5;

    public static final String MAX_STARTING_VALUE = "Maximal starting weights";
    public static final double DEFAULT_MAX_WEIGHT = 0.5;

    public GAParameters() {
        parameters.add(new Parameter(POPULATION_SIZE, ParameterType.INTEGER, 2, 100, DEFAULT_POPULATION_SIZE));
        parameters.add(new Parameter(MAX_GENERATIONS, ParameterType.INTEGER, 1, 10_000,
                DEFAULT_MAX_GENERATIONS));
        parameters.add(new Parameter(TOURNAMENT_SIZE, ParameterType.INTEGER, 2, DEFAULT_POPULATION_SIZE,
                DEFAULT_TOURNAMENT_SIZE));
        parameters.add(new Parameter(ALPHA, ParameterType.DOUBLE, 0, 5, DEFAULT_ALPHA));
        parameters.add(new Parameter(SIGMA, ParameterType.DOUBLE, 0, Parameter.DEFAULT_MAX_VALUE, DEFAULT_SIGMA));
        parameters.add(new Parameter(STOP_CONDITION, ParameterType.DOUBLE, 0, 1, DEFAULT_STOP_CONDITION));

        parameters.add(new Parameter(MIN_STARTING_VALUE, ParameterType.DOUBLE, -10, 0, DEFAULT_MINIMAL_WEIGHT));
        parameters.add(new Parameter(MAX_STARTING_VALUE, ParameterType.DOUBLE, 0, 10, DEFAULT_MAX_WEIGHT));
    }

    @Override
    public Parameter getParameter(String name) {
        return parameters.stream().filter(p -> p.getName().equals(name)).findFirst().get();
    }

    @Override
    public void setParameter(String name, double value) {
        Parameter parameter = parameters.stream().filter(p -> p.getName().equals(name)).findFirst().get();
        parameter.setValue(value);
    }

    @Override
    public LinkedHashSet<Parameter> getParameters() {
        return new LinkedHashSet<>(parameters);
    }

}
