/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.dmacc.cis175.module15.tomcat10.cis175_final_project.music.data;
import java.io.Serializable;
import java.util.Iterator;
import java.util.function.Consumer;

/**
 *
 * @author josep
 */
public class InfiniteSequencer implements Serializable, Iterable {
    private long seed;
    private long next;
    
    public class InfiniteSequencerIterator implements Iterator {
        public InfiniteSequencerIterator() {}
        
        @Override
        public boolean hasNext() {
            return InfiniteSequencer.this.hasNext();
        }

        @Override
        public Object next() {
            return (Long)(InfiniteSequencer.this.next());
        }
    }
    
    public InfiniteSequencer() {
        this.seed = 0;
        this.next = 0;
    }

    public long getSeed() {
        return seed;
    }

    public void setSeed(long seed) {
        this.seed = seed;
        if (this.seed > this.next) {
            this.next = this.seed;
        }
    }

    public long getNext() {
        if (next == Long.MAX_VALUE - 1) {
            next = seed;
        } 
        return ++next;
    }

    public void setNext(long next) {
        this.next = next;
    }
    
    public boolean hasNext() {
        return true;
    }
    
    public long next() {
        if (next == Long.MAX_VALUE - 1) {
            next = seed;
        } 
        return ++next;
    }

    @Override
    public Iterator iterator() {
        return new InfiniteSequencer.InfiniteSequencerIterator();
    }
    
    
}
