package org.example.studyhub.model;
// Enum brukes for å lage egne typer med faste verdier, som VIDEO, PDF, QUIZ osv.
// ResourceType brukes for å definere hva slags type ressurs det er (f.eks. VIDEO eller PDF).
// Det gjør det enklere å jobbe med faste valg og unngår skrivefeil.
public enum ResourceType {
    VIDEO,
    PDF,
    QUIZ,
    ARTICLE,
    LINK
}
