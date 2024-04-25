package com.tierrayaire.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "concerts")
public class Concert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull(message = "Venue cannot be null")
    @Size(min = 1, max = 255, message = "Venue must be between 1 and 255 characters")
    @Column(name = "venue")
    private String venue;

    @Column(name = "venue_link")
    private String venueLink;

    @NotNull(message = "City cannot be null")
    @Size(min = 1, max = 80, message = "City must be between 1 and 80 characters")
    @Column(name = "city")
    private String city;

    @NotNull(message = "Country cannot be null")
    @Size(min = 1, max = 80, message = "Country must be between 1 and 80 characters")
    @Column(name = "country")
    private String country;

    @Column(name = "tickets_link")
    private String ticketsLink;

    @NotNull(message = "Concert date cannot be null")
    @Column(name = "concert_date")
    private LocalDateTime concertDate;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public Concert() {

    }

    public Concert(String venue, String venueLink, String city, String country, String ticketsLink, LocalDateTime concertDate, LocalDateTime createdAt, LocalDateTime updatedAt ) {
        this.venue = venue;
        this.venueLink = venueLink;
        this.city = city;
        this.country = country;
        this.ticketsLink = ticketsLink;
        this.concertDate = concertDate;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getVenueLink() {
        return venueLink;
    }

    public void setVenueLink(String venueLink) {
        this.venueLink = venueLink;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LocalDateTime getConcertDate() {
        return concertDate;
    }

    public void setConcertDate(LocalDateTime concertDate) {
        this.concertDate = concertDate;
    }

    public String getTicketsLink() {
        return ticketsLink;
    }

    public void setTicketsLink(String ticketsLink) {
        this.ticketsLink = ticketsLink;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
