package java17.Q1;

public record UserResponseDto(
        Long id,
        String userName,
        String email,
        boolean active
) {
}
