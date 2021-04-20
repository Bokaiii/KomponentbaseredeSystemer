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



# Dependency Analysis

| NUMBER | CLASS                       | DEPENDS ON                                     | DEPENDENCY DEPTH |
| ------ |:----------------------------| :----------------------------------------------|-----------------:|
| 1      | SilentUpdate                |                                                |                0 |
| 2      | Common                      |                                                |                0 |
| 3      | AsteroidsNetbeansModule-app | SilentUpdate                                   |                1 |
| 4      | Collision                   | Common                                         |                1 |
| 5      | CommonAsteroid              | Common                                         |                1 |
| 6      | CommonBullet                | Common                                         |                1 |
| 7      | CommonEnemy                 | Common                                         |                1 |
| 8      | Core                        | Common                                         |                1 |
| 9      | Asteroid                    | Common, CommonAsteroids                        |                2 |
| 10     | Asteroid2                   | Common, CommonAsteroids                        |                2 |
| 11     | Bullet                      | Common, CommonBullet                           |                2 |
| 12     | Enemy                       | Common, CommonEnemy                            |                2 |
| 13     | Player                      | Common, CommonBullet                           |                2 |

