package com.lh.mywidget;

import java.util.List;

/**
 * Created by Liaohuan on 2016/12/26.
 */
public class DataBean {
    private List<Results> results;

    public void setResults(List<Results> results) {
        this.results = results;
    }

    public List<Results> getResults() {
        return this.results;
    }

    public class Results {
        private String last_update;

        private Location location;

        private Now now;

        public void setLast_update(String last_update) {
            this.last_update = last_update;
        }

        public String getLast_update() {
            return this.last_update;
        }

        public void setLocation(Location location) {
            this.location = location;
        }

        public Location getLocation() {
            return this.location;
        }

        public void setNow(Now now) {
            this.now = now;
        }

        public Now getNow() {
            return this.now;
        }

    }

    public class Now {
        private String clouds;

        private String code;

        private String dew_point;

        private String feels_like;

        private String humidity;

        private String pressure;

        private String temperature;

        private String text;

        private String visibility;

        private String wind_direction;

        private String wind_direction_degree;

        private String wind_scale;

        private String wind_speed;

        public void setClouds(String clouds) {
            this.clouds = clouds;
        }

        public String getClouds() {
            return this.clouds;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getCode() {
            return this.code;
        }

        public void setDew_point(String dew_point) {
            this.dew_point = dew_point;
        }

        public String getDew_point() {
            return this.dew_point;
        }

        public void setFeels_like(String feels_like) {
            this.feels_like = feels_like;
        }

        public String getFeels_like() {
            return this.feels_like;
        }

        public void setHumidity(String humidity) {
            this.humidity = humidity;
        }

        public String getHumidity() {
            return this.humidity;
        }

        public void setPressure(String pressure) {
            this.pressure = pressure;
        }

        public String getPressure() {
            return this.pressure;
        }

        public void setTemperature(String temperature) {
            this.temperature = temperature;
        }

        public String getTemperature() {
            return this.temperature;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getText() {
            return this.text;
        }

        public void setVisibility(String visibility) {
            this.visibility = visibility;
        }

        public String getVisibility() {
            return this.visibility;
        }

        public void setWind_direction(String wind_direction) {
            this.wind_direction = wind_direction;
        }

        public String getWind_direction() {
            return this.wind_direction;
        }

        public void setWind_direction_degree(String wind_direction_degree) {
            this.wind_direction_degree = wind_direction_degree;
        }

        public String getWind_direction_degree() {
            return this.wind_direction_degree;
        }

        public void setWind_scale(String wind_scale) {
            this.wind_scale = wind_scale;
        }

        public String getWind_scale() {
            return this.wind_scale;
        }

        public void setWind_speed(String wind_speed) {
            this.wind_speed = wind_speed;
        }

        public String getWind_speed() {
            return this.wind_speed;
        }

    }

    public class Location {
        private String country;

        private String id;

        private String name;

        private String timezone;

        private String timezone_offset;

        public void setCountry(String country) {
            this.country = country;
        }

        public String getCountry() {
            return this.country;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getId() {
            return this.id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        public void setTimezone(String timezone) {
            this.timezone = timezone;
        }

        public String getTimezone() {
            return this.timezone;
        }

        public void setTimezone_offset(String timezone_offset) {
            this.timezone_offset = timezone_offset;
        }

        public String getTimezone_offset() {
            return this.timezone_offset;
        }

    }
}
