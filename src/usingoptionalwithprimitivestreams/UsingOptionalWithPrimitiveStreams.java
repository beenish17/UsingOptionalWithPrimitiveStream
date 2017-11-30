
package usingoptionalwithprimitivestreams;

import java.util.OptionalDouble;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class UsingOptionalWithPrimitiveStreams {

    public static void main(String[] args) {
        System.out.println("----Caluculating Average Using Primitive Streams-----");
        IntStream stream=IntStream.range(2,5);// 2+3+4/3= 3.0
        //Why we didint use Optional<Double> in the given line below because dealing with primitive we have to use OptionalDouble.
        //Optional<Double> is used with wrapper classes.
        OptionalDouble optional=stream.average();
        System.out.println(optional.getAsDouble());// optional.get canot be used with primitives
        optional.ifPresent(System.out:: println);
        System.out.println(optional.orElseGet(()-> Double.NaN));
        
        System.out.println("---Calculating Sum Using primitive Stream---------------------------------");
        LongStream longs=LongStream.of(5,10);
        long sum=longs.sum();
        System.out.println(sum);
        DoubleStream doubles=DoubleStream.generate(()->Math.PI);//will generate infinte loop.
        OptionalDouble min =doubles.limit(1).min();
        System.out.println(min.getAsDouble());
        System.err.println("----------------------------------------------------");
        
    }
    
}
