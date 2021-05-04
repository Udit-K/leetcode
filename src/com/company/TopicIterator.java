package com.company;

import java.util.List;

public class TopicIterator implements Iterator<Topic>{

    private List<Topic> topics;
    private int index;

    public TopicIterator(List topics) {
        this.topics = topics;
        this.index = 0;
    }

    @Override
    public void reset() {
        index = 0;
    }

    @Override
    public Topic next() {
        return topics.get(index++);
    }

    @Override
    public Topic currentItem() {
        return topics.get(index);
    }

    @Override
    public boolean hasNext() {
        if(index < topics.size()) {
            return true;
        }
        return false;
    }


}
