package com.map.Mappers;

public interface Mapper<A,B> {

    B mapTo(A a);

    A mapFrom(B b);

}

