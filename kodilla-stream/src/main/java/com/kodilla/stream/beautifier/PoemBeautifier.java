package com.kodilla.stream.beautifier;

public class PoemBeautifier {

    public void beautify(String txt, PoemDecorator poemDecorator) {
        System.out.println( poemDecorator.decorate(txt) );
    }
}
