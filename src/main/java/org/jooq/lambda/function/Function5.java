/**
 * Copyright (c) 2014-2016, Data Geekery GmbH, contact@datageekery.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jooq.lambda.function;


import org.jooq.lambda.tuple.Tuple1;
import org.jooq.lambda.tuple.Tuple2;
import org.jooq.lambda.tuple.Tuple3;
import org.jooq.lambda.tuple.Tuple4;
import org.jooq.lambda.tuple.Tuple5;

/**
 * A function with 5 arguments
 *
 * @author Lukas Eder
 */
@FunctionalInterface
public interface Function5<T1, T2, T3, T4, T5, R> {

    /**
     * Apply this function to the arguments.
     *
     * @param args The arguments as a tuple.
     */
    default R apply(Tuple5<? extends T1, ? extends T2, ? extends T3, ? extends T4, ? extends T5> args) {
        return apply(args.v1, args.v2, args.v3, args.v4, args.v5);
    }

    /**
     * Apply this function to the arguments.
     */
    R apply(T1 v1, T2 v2, T3 v3, T4 v4, T5 v5);

    /**
     * Partially apply this function to the arguments.
     */
    default Function4<T2, T3, T4, T5, R> curry(T1 v1) {
        return (v2, v3, v4, v5) -> apply(v1, v2, v3, v4, v5);
    }

    /**
     * Partially apply this function to the arguments.
     */
    default Function3<T3, T4, T5, R> curry(T1 v1, T2 v2) {
        return (v3, v4, v5) -> apply(v1, v2, v3, v4, v5);
    }

    /**
     * Partially apply this function to the arguments.
     */
    default Function2<T4, T5, R> curry(T1 v1, T2 v2, T3 v3) {
        return (v4, v5) -> apply(v1, v2, v3, v4, v5);
    }

    /**
     * Partially apply this function to the arguments.
     */
    default Function1<T5, R> curry(T1 v1, T2 v2, T3 v3, T4 v4) {
        return (v5) -> apply(v1, v2, v3, v4, v5);
    }

    /**
     * Partially apply this function to the arguments.
     */
    default Function0<R> curry(T1 v1, T2 v2, T3 v3, T4 v4, T5 v5) {
        return () -> apply(v1, v2, v3, v4, v5);
    }

    /**
     * Partially apply this function to the arguments.
     */
    default Function4<T2, T3, T4, T5, R> curry(Tuple1<? extends T1> args) {
        return (v2, v3, v4, v5) -> apply(args.v1, v2, v3, v4, v5);
    }

    /**
     * Partially apply this function to the arguments.
     */
    default Function3<T3, T4, T5, R> curry(Tuple2<? extends T1, ? extends T2> args) {
        return (v3, v4, v5) -> apply(args.v1, args.v2, v3, v4, v5);
    }

    /**
     * Partially apply this function to the arguments.
     */
    default Function2<T4, T5, R> curry(Tuple3<? extends T1, ? extends T2, ? extends T3> args) {
        return (v4, v5) -> apply(args.v1, args.v2, args.v3, v4, v5);
    }

    /**
     * Partially apply this function to the arguments.
     */
    default Function1<T5, R> curry(Tuple4<? extends T1, ? extends T2, ? extends T3, ? extends T4> args) {
        return (v5) -> apply(args.v1, args.v2, args.v3, args.v4, v5);
    }

    /**
     * Partially apply this function to the arguments.
     */
    default Function0<R> curry(Tuple5<? extends T1, ? extends T2, ? extends T3, ? extends T4, ? extends T5> args) {
        return () -> apply(args.v1, args.v2, args.v3, args.v4, args.v5);
    }
}
