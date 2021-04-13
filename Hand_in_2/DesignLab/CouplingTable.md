# Coupling Table

| NUMBER | CLASS              | DEPENDS ON                                     | DEPENDENCY DEPTH |
| ------ |:-------------------| :----------------------------------------------|-----------------:|
| 1      | GameKeys           |                                                |                0 |
| 2      | GameInputProcessor | GameKeys                                       |                1 |
| 3      | PlayState          | Player, Gamestate, GameKeys, GameStateManager  |                4 |
| 4      | GameStateManager   | GameState, PlayState                           |                5 |
| 5      | Game               | GameInputProcessor, GameKeys, GameStateManager |                5 |
| 6      | SpaceObject        | Game                                           |                5 |
| 7      | Player             | SpaceObject, Game                              |                5 |
| 8      | GameState          | GameStateManager                               |                6 |
| 9      | Main               | Game                                           |                6 |

Det er valgt at stoppe *Dependency Depth* når de bliver cykliske. Et eksempel
kan ses nedenfor.
```
PlayState -> Player -> SpaceObject -> Game -> GameStateManager
```

Da GameStateManager fører tilbage til PlayState er denne dependency cyklisk.
