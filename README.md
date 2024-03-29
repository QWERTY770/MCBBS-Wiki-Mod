# MCBBS Wiki Mod

## Dependencies
__Minecraft__: 1.16 —— 1.16.5(recommended), updating to 1.17 -- 1.17.1

__Forge__: 1.16: 33-36(recommended)  1.17: 37

## How to install
+ Download JAR file from https://www.mcmod.cn/download/3343.html
+ Download JAR file and source code from https://github.com/QWERTY770/MCBBS-Wiki-Mod/releases
+ Build from source: Please read the information at the bottom of these words.

## Mod introduction
See https://www.mcmod.cn/class/3343.html

## Version
Latest beta version: 0.8b2 on 27 Feb, 2021

Latest stable version: 0.7 on 1 Feb, 2021

Versions except these are not supported. Please update to a new version.

## External links:
MCMOD: https://www.mcmod.cn/class/3343.html

MCBBS: https://www.mcbbs.net/thread-1156129-1-1.html


-------------------------------------------
Here is the standard `readme.txt` by Forge:

-------------------------------------------
Source installation information for modders
-------------------------------------------
This code follows the Minecraft Forge installation methodology. It will apply
some small patches to the vanilla MCP source code, giving you and it access
to some of the data and functions you need to build a successful mod.

Note also that the patches are built against "unrenamed" MCP source code (aka
srgnames) - this means that you will not be able to read them directly against
normal code.

Source pack installation information:

Standalone source installation
==============================

See the Forge Documentation online for more detailed instructions:
http://mcforge.readthedocs.io/en/latest/gettingstarted/

Step 1: Open your command-line and browse to the folder where you extracted the zip file.

Step 2: You're left with a choice.
If you prefer to use Eclipse:
1. Run the following command: "gradlew genEclipseRuns" (./gradlew genEclipseRuns if you are on Mac/Linux)
2. Open Eclipse, Import > Existing Gradle Project > Select Folder
   or run "gradlew eclipse" to generate the project.
   (Current Issue)
4. Open Project > Run/Debug Settings > Edit runClient and runServer > Environment
5. Edit MOD_CLASSES to show [modid]%%[Path]; 2 times rather then the generated 4.

If you prefer to use IntelliJ:
1. Open IDEA, and import project.
2. Select your build.gradle file and have it import.
3. Run the following command: "gradlew genIntellijRuns" (./gradlew genIntellijRuns if you are on Mac/Linux)
4. Refresh the Gradle Project in IDEA if required.

If at any point you are missing libraries in your IDE, or you've run into problems you can run "gradlew --refresh-dependencies" to refresh the local cache. "gradlew clean" to reset everything {this does not affect your code} and then start the processs again.

Should it still not work,
Refer to #ForgeGradle on EsperNet for more information about the gradle environment.
or the Forge Project Discord discord.gg/UvedJ9m

Forge source installation
=========================
MinecraftForge ships with this code and installs it as part of the forge
installation process, no further action is required on your part.

LexManos' Install Video
=======================
https://www.youtube.com/watch?v=8VEdtQLuLO0&feature=youtu.be

For more details update more often refer to the Forge Forums:
