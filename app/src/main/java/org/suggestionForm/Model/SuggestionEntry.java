package org.suggestionForm.Model;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class SuggestionEntry {
	private @NonNull String title;
	private @NonNull String description;
	private final LocalDate dateSubmitted;
}
