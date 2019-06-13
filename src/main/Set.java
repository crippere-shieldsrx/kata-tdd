package main;

import java.util.ArrayList;

public class Set<t> {

    public boolean contains(t candidate) {
        return members.contains(candidate);
    }

    public Set(ArrayList<t> members) {
        this.members = members;
    }

    public Set() {
    }

    private ArrayList<t> members = new ArrayList();

    public void add(t member) {
        members.add(member);
    }

    protected ArrayList<t> getMembers() {
        return members;
    }

    public Set(Set<t> members) {
        members.getMembers().forEach(m -> {
            this.members.add(m);
        });
    }

    public Set union(Set other) {
        Set result = new Set(this);

        other.getMembers().forEach(m -> {
            result.add(m);
        });

        return result;
    }

    public Set intersect(Set other) {
        ArrayList<t> others = other.members;

        Set result = new Set();

        this.getMembers().forEach(m -> {
            if (others.contains(m)) {
                result.add(m);
            }
        });

        return result;
    }

//    public int size() {
//        return -1;
//        //return members.size();
//        //return members.stream().distinct().count();
//    }
}
