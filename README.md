# Car Simulation Settings Widget
An application that helps changing the initial values of the [car-simulation](https://github.com/abdulrahmanKanakri/car-simulation-lwjgl) project.


## Overview
The application is built using JavaFX. The goal of it is to display car velocity and acceleration in real-time, in addition to the ability to change available environment variables.


## Available environment variables
| Key                  | Default value | Description                                                           |
|----------------------|:-------------:|-----------------------------------------------------------------------|
| engineTorque         |      150      | the engine torque                                                     |
| rollingFrictionForce |     0.02f     | the friction with the ground                                          |
| carMass              |     1400      | car mass                                                              |
| brakeCoefficient     |     0.7f      | brake coefficient                                                     |
| roadDegree           |      10       | there's a road in the plant that have a degree for gravity simulation |
| airResistanceX       |      50       | air resistance in x axis                                              |
| airResistanceY       |       0       | air resistance in y axis                                              |
| airResistanceZ       |      -20      | air resistance in z axis                                              |

## How to use

First you should run this application then run the Car Simulation project,
because the Car Simulation project expects the application is available
and can import the initial values from it.


## Application widget example
![Application widget example.](/images/sample.png)
