package com.kodilla.good.patterns.flight.database;

public interface Flight {

    String getDepartureAirport();
    String getArrivalAirport();

   /* int hashCode();
    boolean equals(Object o);*/

    /*No, you can't. What you can do, however, is use an abstract base class instead of an interface,
    and make equals() abstract:

    abstract class Flight {
        // put other methods from Command interface here

        public abstract boolean equals(Object other);
        public abstract int hashCode();
    }
    Subclasses of Command must then provide their own equals and hashCode methods.
    It's generally bad practice to force API users to extend a base class but it may be justified in this case.
     Also, if you make Command an abstract base class instead of an interface, rather than introducing an
     artificial base class in addition to the Command interface, then there's no risk of your API users getting
     it wrong.
*/}
