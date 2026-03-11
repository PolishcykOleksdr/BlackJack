```mermaid
erDiagram
    Card {
        Rank rank
        Suit suit
    }
    Card ||--|| Rank : "has"
    Card ||--|| Suit : "has"
```