package org.example.models;

public record LoginResponse(int userId, String username, String jwtResponse) {
}
