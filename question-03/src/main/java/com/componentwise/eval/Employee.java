package com.componentwise.eval;

import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Optional;
import static java.util.Optional.empty;
import static java.util.Optional.of;

/**
 * I implemented the changes by adding a part time flag and a method
 * for retrieving it.
 * 
 * I made the class immutable and created methods for changing the
 * statuses by creating new Employee objects with appropriate
 * values.
 * 
 * I assume that name, id, and dateHired will never change.
 **/
public final class Employee {
    private final String name;

    private final int id;

    private final Date dateHired;

    private final boolean isManagerFlag;

    private final boolean isPartTimeFlag;

    /**
     *  I assume most employees are full-time, non-managers.
     **/
    public Employee(final String _name, final int _id, final Date _dateHired){
        this(_name, _id, _dateHired, false, false);
    }

    public Employee(final String _name, final int _id, final Date _dateHired,
    final boolean _isManager, final boolean _isPartTime){
        this.name=_name;
        this.id=_id;
        this.dateHired=_dateHired;
        this.isManagerFlag=_isManager;
        this.isPartTimeFlag=_isPartTime;
    }

    public Employee setPartTimeStatus(boolean status){
        return new Employee(name, id, dateHired, isManager, status);
    }

    public Employee setManagerStatus(boolean status){
        return new Employee(name, id, dateHired, status, isPartTime);
    }

    public String getName(){
        return this.name;
    }

    public int getId(){
        return this.id;
    }

    public Date getDateHired(){
        return this.dateHired;
    }

    public boolean isManager(){
        return this.isManagerFlag;
    }

    public boolean isPartTime(){
        return this.isPartTimeFlag;
    }

    @Override
    public boolean equals(Object oth){
        return oth instanceof Employee ? ((Employee)(oth)).equals(this) : false;
    }

    private boolean equals(Employee oth){
        return this.id==oth.id;
    }

    @Override
    public int hashCode(){
        return this.id;
    }
}