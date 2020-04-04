package it.contrader.model;

import java.sql.Date;
import java.sql.Time;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class AssignmentParking {

        private  int id;
        private  int idCar;
        private  int idPostiAuto;
        private  Date entryDate;
        private  Time entryTime;

        //prezzo parcheggio per un ora
        public  static final int PRICE = 2;

        public AssignmentParking() {

        }

        public AssignmentParking(int idCar,int idPostiAuto) {
            this.idCar       = idCar;
            this.idPostiAuto = idPostiAuto;
            this.entryDate   = Date.valueOf(LocalDate.now());
            this.entryTime   = Time.valueOf(LocalTime.now());
        }
        public AssignmentParking(int id, int idCar, int idPostiAuto) {
        	this.id                  = id;
        	this.idCar       = idCar;
        	this.idPostiAuto = idPostiAuto;
        	this.entryDate   = Date.valueOf(LocalDate.now());
        	this.entryTime   = Time.valueOf(LocalTime.now());
        }
        /**
         * returns the total price calculated based on the hours that a car has been inside a parking lot.
         * @return totalPrice
         * */
        public int calculateTotalPrice() {
        	int totalPrice;
        	LocalDate entryDate = this.getEntryDate().toLocalDate();
        	LocalTime entryTime = this.getEntryTime().toLocalTime();
        	LocalDateTime entryLocalDateTime = entryTime.atDate(entryDate);
        	Duration duration = Duration.between(entryLocalDateTime, LocalDateTime.now());
        	int durationHour = (int) Math.abs(duration.toHours());
        	totalPrice = durationHour * PRICE;
        	return totalPrice;
        }
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getIdCar() {
        	return idCar;
        }

        public void setIdCar(int idCar) {
        	this.idCar = idCar;
        }

        public int getIdPostiAuto() {
        	return idPostiAuto;
        }

        public void setIdPostiAuto(int idPostiAuto) {
        	this.idPostiAuto = idPostiAuto;
        }
        public Date getEntryDate() {
        	return entryDate;
        }

        public void setEntryDate(Date entryDate) {
        	this.entryDate = entryDate;
        }

        public Time getEntryTime() {
        	return entryTime;
        }

        public void setEntryTime(Time entryTime) {
        	this.entryTime = entryTime;
        }
        @Override
        public boolean equals(Object obj) {
        	//self check
        	if(this == obj) {
        		return true;
        	}
        	//null check
        	if(obj == null) {
        		return false;
        	}
        	//type check and cast
        	if(getClass()!=obj.getClass()) {
        		return false;
        	}
        	AssignmentParking ap = (AssignmentParking) obj;
        	//field Comparison
        	if(id != ap.id) {
        		return false;
        	}
        	if(idCar!=ap.idCar || idPostiAuto != ap.idPostiAuto) {
        		return false;
        	}
        	return true;

        }

        @Override
        public String toString() {
        	return  id + "\t"  + idCar +"\t\t" +   idPostiAuto + "\t\t"
        			+ entryDate + "\t\t" + entryTime + "\t\tTotalCurrentPrice: " +calculateTotalPrice();
        }

}








