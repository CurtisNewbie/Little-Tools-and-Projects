# Simple Painter

Simple app allows you to paint/erase on a canvas.

Developed using:

- JavaFX
- JavaSE (11)

## How to run it

Maven and JDK 11 should be installed.

To run it:

    mvn javafx:run;

To resolve dependencies (if dependencies are somehow not downloaded properly):

    mvn dependency:resolve;

## Hotkeys and Configuration

- `Width` and `Height` are optional, default will be used if none provided.
- `Arrow_Up` and `Arrow_Down keys` allow you to increase/decrease stroke width.
- `Primary mouse key` is used to draw (black).
- `Secondary mouse key` is used to erase.

## Demo

<img src="https://user-images.githubusercontent.com/45169791/73143571-af154b80-4093-11ea-8788-06dcc4cf782f.gif">
