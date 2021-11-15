# Ktlyns

.NET C# Compiler for K@ files into executables. Currently under development with very placeholder functionalities. 

## Getting Started
In later versions I will make available a minimalist executable to compile files and projects. For now it requires to compile the project to use the tool:
1. Clone the project
2. Open it with your prefered IDE (E.g. Visual Studio) and compile it.
3. Run the project, by default it will compile a "script.k_at" file which is already located in the project. In future versions you will be able to select the file from anywhere else.
4. On console will be displayed any issues while compiling or if it was succesful. If everything worked you should have a new .exe file which will run the K@ file.

## Prerequisites
- .NET Core

## Deployment
Simply share the binaries and executable created from Ktlyns and it should run in any Windows system. In the future options to compile to different systems will be available to the user.

## Built With
* [LLVM](https://llvm.org/) - IR and JIT compiler.
* [Antlr](https://www.antlr.org/) - Lexer and Parser

## Authors
* **Guillermo Abajo** - *Initial work* - [Luxgile](https://github.com/luxgile)

## License
This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments
* Always thanks to those poor souls in StackOverflow.
* Thanks to [Randy](https://www.youtube.com/c/RandallThomas/featured) who inspired me to reinvent the wheel.
