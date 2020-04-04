package it.contrader.dto;

import java.sql.Date;
import java.sql.Time;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class AssignmentParkingDTO {
	
        private  int id;
        private  int id_car;
        private  int id_parkingplace;
        private  Date entryDate;
        private  Time entryTime;
        public  static final int PRICE = 2;
        
        public AssignmentParkingDTO() {

        }

        public AssignmentParkingDTO(int id_car,int id_parkingplace) {
            this.id_car          = id_car;
            this.id_parkingplace = id_parkingplace;
            this.entryDate       = Date.valueOf(LocalDate.now());
            this.entryTime       = Time.valueOf(LocalTime.now());
        }

        public AssignmentParkingDTO(int id, int id_car,int id_parkingplace) {
            this.id                      = id;
            this.id_car          = id_car;
            this.id_parkingplace = id_parkingplace;
            this.entryDate       = Date.valueOf(LocalDate.now());
            this.entryTime       = Time.valueOf(LocalTime.now());
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
            return id_car;
        }

        public void setIdCar(int id_car) {
            this.id_car = id_car;
        }

        public int getIdPostiAuto() {
            return id_parkingplace;
        }

        public void setIdPostiAuto(int id_parkingplace) {
            this.id_parkingplace = id_parkingplace;
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
        public String toString() {
            return  this.getId() + "\t"  + id_car +"\t\t" +   id_parkingplace + "\t"
                    + entryDate + "\t" + entryTime + "\t\t" +calculateTotalPrice();
        }
}