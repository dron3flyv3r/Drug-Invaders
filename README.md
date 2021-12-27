## Welcome to Drug Invaders

This code was a school project, and all the code is made by [Drun3flyv3r](https://github.com/dron3flyv3r), [Antonyo](https://github.com/AntonyoDK) Kristoffer & [SomeInternetUser](https://github.com/SomeInternetUser)

The game is totaly original.... not the game was very inspired by Space Invaders.

### How to run the program
It is very simple to run the game, I know there are .jar file but i can't get it to work.

1. Download the code [Drug-Invaders](https://github.com/dron3flyv3r/Drug-Invaders)
2. Open it in a Java IDE, like [VSCode](https://code.visualstudio.com/)
3. Click run, play and have fun
4. (optional) modify the code, have fun, copy the code for orders projects and so on

### How it works (very simple)

The code that basicly run the programe is this

```markdown
public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks; 
        double delta = 0;
        while (true) {
            long now = System.nanoTime();
            delta += (now - lastTime)/ns;
            lastTime = now;
            if (delta >= 1) {
                move();
                checkCollision();
                delta--;
            }
        repaint();
        }        
    }
```

I'm that is my engien, that run the programe. I know it is not efficient at all, but it get the job don. If you would like to try the game, you have to [download the game](https://github.com/dron3flyv3r/Drug-Invaders) in to you're java IDE like [VSCode](https://code.visualstudio.com/) or something. 
And then open the SRC where the source files or Java files are.  
Then you can run the programe, and modifie the files or what ever you want.

### Made by
Made by [Drun3flyv3r](https://github.com/dron3flyv3r), [Antonyo](https://github.com/AntonyoDK) Kristoffer & [SomeInternetUser](https://github.com/SomeInternetUser)
