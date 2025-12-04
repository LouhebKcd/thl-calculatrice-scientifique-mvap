grammar Calculette;

// Définition de membres spécifiques au parser
@parser::members {

    //Déclaration de variables privées
    private int _cur_label = 0;
    private String newLabel() { return "Label" + (_cur_label++); }; 
    private TablesSymboles tablesSymboles = new TablesSymboles();

    // Fonction pour évaluer une expression arithmétique
    private String evalexpr(String x, String op, String y, String type) {
        if (type.equals("int")) {
            switch (op) {
                case "*": return x + y + "MUL\n";
                case "/": return x + y + "DIV\n";
                case "+": return x + y + "ADD\n";
                case "-": return x + y + "SUB\n";
                case "%": return x + y + "MOD\n";
                default:
                    System.err.println("Operateur arithmetique incorrect : '" + op + "'");
                    throw new IllegalArgumentException("Operateur arithmétique incorrect : '" + op + "'");
            }
        } else if (type.equals("double")) {
            switch (op) {
                case "*": return x + y + "FMUL\n";
                case "/": return x + y + "FDIV\n";
                case "+": return x + y + "FADD\n";
                case "-": return x + y + "FSUB\n";
                default:
                    System.err.println("Operateur arithmetique incorrect : '" + op + "'");
                    throw new IllegalArgumentException("Operateur arithmétique incorrect : '" + op + "'");
            }
        } else {
            System.err.println("Type d'opérande incorrect : '" + type + "'");
            throw new IllegalArgumentException("Type d'opérande incorrect : '" + type + "'");
        }
    }

    // Fonction pour évaluer une condition
    private String evalCondition(String leftCode, String operator, String rightCode, String type) {
        String code = leftCode + rightCode;
        if (type.equals("int")) {
            switch (operator) {
                case "<": code += "INF\n"; break;
                case ">": code += "SUP\n"; break;
                case "==": code += "EQUAL\n"; break;
                case "<>": code += "NEQ\n"; break;
                case "<=": code += "INFEQ\n"; break;
                case ">=": code += "SUPEQ\n"; break;
                default:
                    System.err.println("Operateur relationnel incorrect : '" + operator + "'");
                    throw new IllegalArgumentException("Operateur relationnel incorrect : '" + operator + "'");
            }
        } else if (type.equals("double")) {
            switch (operator) {
                case "<": code += "FINF\n"; break;
                case ">": code += "FSUP\n"; break;
                case "==": code += "FEQUAL\n"; break;
                case "<>": code += "FNEQ\n"; break;
                case "<=": code += "FINFEQ\n"; break;
                case ">=": code += "FSUPEQ\n"; break;
                default:
                    System.err.println("Operateur relationnel incorrect : '" + operator + "'");
                    throw new IllegalArgumentException("Operateur relationnel incorrect : '" + operator + "'");
            }
        } else {
            System.err.println("Type d'opérande incorrect : '" + type + "'");
            throw new IllegalArgumentException("Type d'opérande incorrect : '" + type + "'");
        }
        return code;
    }

}

// Définition du point d'entrée de la grammaire
start : calcul EOF;

// Définition de la règle "calcul" qui représente le cœur de notre langage
calcul returns [String code] 
@init{ $code = new String(); }   
@after{ System.out.println($code); }
    :   (declaration { $code += $declaration.code; })*        
        { $code += "  JUMP Main\n"; }
        NEWLINE*
        
        (fonction { $code += $fonction.code; })* 
        NEWLINE*
        
        { $code += "LABEL Main\n"; }
        (instruction { $code += $instruction.code; })*
        { $code += "  HALT\n"; } 
    ;

// Définition de la règle pour les déclarations de variables
declaration returns [String code]
    // Déclaration de variable sans affectation
    : TYPE IDENTIFIANT finInstruction
    {
        String varName = $IDENTIFIANT.text;
        String varType = $TYPE.text;
        tablesSymboles.addVarDecl(varName, varType);
        $code = "";
        if (varType.equals("int") ||varType.equals("bool") ) {
             $code += "PUSHI 0\n";
        } else if(varType.equals("double")){
            $code += "PUSHF 0.0\n";
        }else{
            System.err.println("Type de variable non pris en charge : '" + varType + "'");
            throw new IllegalArgumentException("Type de variable non pris en charge : '" + varType + "'");
        }
    }
    // Déclaration de variable avec affectation
    | TYPE IDENTIFIANT '=' expression finInstruction
    {
        String varName = $IDENTIFIANT.text;
        String varType = $TYPE.text;
        tablesSymboles.addVarDecl(varName, varType);
        VariableInfo varInfo = tablesSymboles.getVar($IDENTIFIANT.text);

        if (varType.equals("int")) {
            $code = "PUSHI 0\n";
            $code += $expression.code;
            if (VariableInfo.Scope.PARAM == varInfo.scope) {
                $code += "STOREL " + tablesSymboles.getVar($IDENTIFIANT.text).address + "\n";
            } else if (VariableInfo.Scope.GLOBAL == varInfo.scope) {
                $code += "STOREG " + tablesSymboles.getVar($IDENTIFIANT.text).address + "\n";
            }else if (VariableInfo.Scope.LOCAL == varInfo.scope){
                $code += "STOREG " + tablesSymboles.getVar($IDENTIFIANT.text).address + "\n";
            }else{ 
                System.err.println("erreur scope de la variable dans declaration");
            }
        } else if (varType.equals("double")) {
            $code = "PUSHF 0.0\n";
            $code += $expression.code;
            if (VariableInfo.Scope.PARAM == varInfo.scope) {
                $code += "STOREL " + (tablesSymboles.getVar($IDENTIFIANT.text).address+1 ) + "\n";
                $code += "STOREL " + tablesSymboles.getVar($IDENTIFIANT.text).address + "\n";
            } else if (VariableInfo.Scope.GLOBAL == varInfo.scope) {
                $code += "STOREG " + (tablesSymboles.getVar($IDENTIFIANT.text).address+1 )+ "\n";
                $code += "STOREG " + tablesSymboles.getVar($IDENTIFIANT.text).address + "\n";
            }else if (VariableInfo.Scope.LOCAL == varInfo.scope){
                $code += "STOREG " + (tablesSymboles.getVar($IDENTIFIANT.text).address+1 )+ "\n";
                $code += "STOREG " + tablesSymboles.getVar($IDENTIFIANT.text).address + "\n";
            }else{ 
                System.err.println("erreur scope de la variable dans declaration");
            }

        } else {
            System.err.println("Type de variable non pris en charge : '" + varType + "' dans declaration");
            throw new IllegalArgumentException("Type de variable non pris en charge : '" + varType + "'");
        }
    }
    // Déclaration de variable de type booléen avec affectation
    | TYPE IDENTIFIANT '=' condition finInstruction
    {
        String varName = $IDENTIFIANT.text;
        String varType = $TYPE.text;
        tablesSymboles.addVarDecl(varName, varType);
        VariableInfo varInfo = tablesSymboles.getVar($IDENTIFIANT.text);

        if (varType.equals("bool")) {
            $code = "PUSHI 0\n";
            $code += $condition.code;
            if (VariableInfo.Scope.PARAM == varInfo.scope) {
                $code += "STOREL " + tablesSymboles.getVar($IDENTIFIANT.text).address + "\n";
            } else if (VariableInfo.Scope.GLOBAL == varInfo.scope) {
                $code += "STOREG " + tablesSymboles.getVar($IDENTIFIANT.text).address + "\n";
            }else if (VariableInfo.Scope.LOCAL == varInfo.scope){
                $code += "STOREG " + tablesSymboles.getVar($IDENTIFIANT.text).address + "\n";
            }else{ 
                System.err.println("erreur scope de la variable dans declaration");
            }
        } 
        else {
            System.err.println("Type de variable non pris en charge : '" + varType + "' dans declaration");
            throw new IllegalArgumentException("Type de variable non pris en charge : '" + varType + "'");
        }
    }
    ;

// Définition de la règle pour les assignations de valeurs aux variables
assignation returns [String code]
    
    // Assignation simple
    : IDENTIFIANT '=' expression
        {  
           $code = $expression.code;
           VariableInfo varInfo = tablesSymboles.getVar($IDENTIFIANT.text);

           if (varInfo != null) {
                if(varInfo.type.equals("int")){
                    if (VariableInfo.Scope.PARAM == varInfo.scope) {
                        $code += "STOREL " + varInfo.address + "\n";
                    } else if (VariableInfo.Scope.GLOBAL == varInfo.scope) {
                        $code += "STOREG " + varInfo.address + "\n";
                    }else if (VariableInfo.Scope.LOCAL == varInfo.scope){
                        $code += "STOREG " + varInfo.address + "\n";
                    }else{
                        System.err.println("erreur scope de la variable de type int dans assignation");
                    }
                }else{
                    if (VariableInfo.Scope.PARAM == varInfo.scope) {
                        $code += "STOREL " + (varInfo.address + 1)+ "\n";
                        $code += "STOREL " + varInfo.address + "\n";
                    } else if (VariableInfo.Scope.GLOBAL == varInfo.scope) {
                        $code += "STOREG " + (varInfo.address+1) + "\n";
                        $code += "STOREG " + varInfo.address + "\n";
                    }else if (VariableInfo.Scope.LOCAL == varInfo.scope) {
                        $code += "STOREG " + (varInfo.address+1) + "\n";
                        $code += "STOREG " + varInfo.address + "\n";
                    }else{
                        System.err.println("erreur scope de la variable de type double dans assignation");
                    }
                }
           }else {
                System.err.println("La variable '" + $IDENTIFIANT.text + "' n'est pas déclarée");
                throw new IllegalArgumentException("La variable '" + $IDENTIFIANT.text + "' n'est pas déclarée");
           }
        }

    // Assignation avec addition
    | IDENTIFIANT '+=' expression
        {   
            VariableInfo varInfo = tablesSymboles.getVar($IDENTIFIANT.text);
            $code = $expression.code;
            if($expression.exprType.equals("int")){
                if (VariableInfo.Scope.PARAM == varInfo.scope) {
                $code += "PUSHL " + varInfo.address + "\n";
                } else if (VariableInfo.Scope.GLOBAL == varInfo.scope) {
                    $code += "PUSHG " + varInfo.address + "\n";
                }else if (VariableInfo.Scope.LOCAL == varInfo.scope) {
                    $code += "PUSHG " + varInfo.address + "\n";
                }else{
                    System.err.println("erreur scope de la variable dans assignation += ");
                }
                $code += "ADD\n";
                if (VariableInfo.Scope.PARAM == varInfo.scope) {
                    $code += "STOREL " + varInfo.address + "\n";
                } else if (VariableInfo.Scope.GLOBAL == varInfo.scope){
                $code += "STOREG " + varInfo.address + "\n";
                } if (VariableInfo.Scope.LOCAL == varInfo.scope){
                $code += "STOREG " + varInfo.address + "\n";
                }else{
                    System.err.println("erreur scope de la variable dans assignation += ");
                } 

            }else if($expression.exprType.equals("double")){
                if (VariableInfo.Scope.PARAM == varInfo.scope) {
                    $code += "PUSHL " +(varInfo.address+1)+"\n";
                    $code += "PUSHL " +varInfo.address+"\n";
                } else if (VariableInfo.Scope.GLOBAL == varInfo.scope) {
                    $code += "PUSHG " + (varInfo.address+1) + "\n";
                    $code += "PUSHG " + varInfo.address + "\n";
                }else if (VariableInfo.Scope.LOCAL == varInfo.scope) {
                    $code += "PUSHG " + (varInfo.address+1) + "\n";
                    $code += "PUSHG " + varInfo.address + "\n";
                }else{
                    System.err.println("erreur scope de la variable dans assignation += ");
                }
                $code += "ADD\n";
                if (VariableInfo.Scope.PARAM == varInfo.scope) {
                    $code += "STOREL " + varInfo.address + "\n";
                    $code += "STOREL " + (varInfo.address+1) + "\n";
                } else if (VariableInfo.Scope.GLOBAL == varInfo.scope){
                    $code += "STOREG " + varInfo.address + "\n";
                    $code += "STOREG " + (varInfo.address+1) + "\n";
                } if (VariableInfo.Scope.LOCAL == varInfo.scope){
                    $code += "STOREG " + varInfo.address + "\n";
                    $code += "STOREG " + (varInfo.address+1) + "\n";
                }else{
                    System.err.println("erreur scope de la variable dans assignation += ");
                } 
            }else{
                System.err.println("Type de variable non pris en charge dans assignation");

            }
            
        }

        // Assignation pour les booléens
        |IDENTIFIANT '=' condition
        {  
           $code = $condition.code;
           VariableInfo varInfo = tablesSymboles.getVar($IDENTIFIANT.text);

           if (varInfo != null) {
                if(varInfo.type.equals("bool")){
                    if (VariableInfo.Scope.PARAM == varInfo.scope) {
                        $code += "STOREL " + varInfo.address + "\n";
                    } else if (VariableInfo.Scope.GLOBAL == varInfo.scope) {
                        $code += "STOREG " + varInfo.address + "\n";
                    }else if (VariableInfo.Scope.LOCAL == varInfo.scope){
                        $code += "STOREG " + varInfo.address + "\n";
                    }else{
                        System.err.println("erreur scope de la variable de type int dans assignation");
                    }
                }
           }else {
                System.err.println("La variable '" + $IDENTIFIANT.text + "' n'est pas déclarée");
                throw new IllegalArgumentException("La variable '" + $IDENTIFIANT.text + "' n'est pas déclarée");
           }
        }
    ;

// Définition de la règle pour les instructions de lecture d'entrée
readlnInstruction returns [String code]
    : 'readln' '(' IDENTIFIANT ')'
    {
        VariableInfo varInfo = tablesSymboles.getVar($IDENTIFIANT.text);
        if (varInfo != null) {
            $code = "";

            //Lecture d'une valeur entière depuis l'entrée standard
            if(varInfo.type.equals("int")){
                $code += "READ\n";
                if (VariableInfo.Scope.PARAM == varInfo.scope) {
                    $code += "STOREL " + varInfo.address + "\n";
                } else {
                    $code += "STOREG " + varInfo.address + "\n";
                }
            
            // Lecture d'une valeur flottante depuis l'entrée standard
            } else if(varInfo.type.equals("double")){
                $code += "READF\n";
                if (VariableInfo.Scope.PARAM == varInfo.scope) {
                    $code += "STOREL " + (varInfo.address + 1) + "\n";
                    $code += "STOREL " + varInfo.address + "\n";
                } else {
                    $code += "STOREG " + (varInfo.address + 1) + "\n";
                    $code += "STOREG " + varInfo.address + "\n";
                }
            }else{
                System.err.println("Type de variable non pris en charge : '" + varInfo.type + "' dans readlnInstruction");
            }    
        } else {
            System.err.println("La variable '" + $IDENTIFIANT.text + "' n'est pas déclarée dans readlnInstruction");
            throw new IllegalArgumentException("La variable '" + $IDENTIFIANT.text + "' n'est pas déclarée");
        }
    }
    ;

// Définition de la règle pour les instructions d'affichage de sortie
printlnInstruction returns [String code]
    : 'println' '(' expression ')'
    {   
        // Affichage d'une expression entière , décimale ou booléenne
        if($expression.exprType.equals("double")){
            $code = $expression.code + "WRITEF \nPOP\nPOP \n";
        }else if($expression.exprType.equals("int") || $expression.exprType.equals("bool")){
            $code = $expression.code + "WRITE \nPOP \n";
        }else{
            System.err.println("Type d'expression  non pris en charge dans printlnInstruction");
        }
    }
    ;

// Définition de la règle générale pour les instructions
instruction returns [String code] 
    // Instruction simple
    : expression finInstruction 
        { 
            $code = $expression.code;
        }

       // Instruction daffichage
    |  printlnInstruction finInstruction
        { 
            $code = $printlnInstruction.code;
        }

      // Instruction dassignation
    | assignation finInstruction
        { 
            $code = $assignation.code;
        }

      // Instruction de retour
    | RETURN expression finInstruction    
        {
            VariableInfo returnVarInfo = tablesSymboles.getReturn();
            $code = $expression.code;
            if($expression.exprType.equals("int")){
                $code += "STOREL " + returnVarInfo.address + "\n";
                
            }else if($expression.exprType.equals("double")){
                    $code += "STOREL " + (returnVarInfo.address + 1) + "\n";
                    $code += "STOREL " + returnVarInfo.address + "\n";
            }
            else{
                System.err.println("Type d'expression  non pris en charge dans RETURN");
            }
            $code+="RETURN\n";
        }

       // Instruction de lecture
    | readlnInstruction finInstruction
        {
            $code = $readlnInstruction.code;
        }

      // Bloc dinstructions
    | bloc
        { 
            $code = $bloc.code;
        }

      // Boucle while
    | whileInstruction 
        { 
            $code = $whileInstruction.code;
        }

      // Boucle for
    | forInstruction
        { 
            $code = $forInstruction.code;
        }
      //Structure conditionnelle if-else
    | ifElse
        {
            $code = $ifElse.code;
        }

    | finInstruction
        {
            $code="";
        }
    ;

args returns [String code, int size] 
@init{ $code = new String(); $size = 0; }
    : ( expression 
    {
        $code = $expression.code;
        if($expression.exprType.equals("double")){
            $size+=2;    
        }
        else if($expression.exprType.equals("int")){
            $size+=1;    
        }
        
    }
    ( ',' expression
        {
            
            $code += $expression.code;
            if($expression.exprType.equals("double")){
                $size+=2;    
            }
            else if($expression.exprType.equals("int")){
                $size+=1;    
            }        
        }
    )*
      )?
    ;

// Définition de la règle pour les expressions
expression returns [String code , String exprType]
    : 
    // Expression - unaire
    '-' a=expression { $code = $a.code + "PUSHI -1\nMUL\n"; $exprType = $expression.exprType;}

    // Expression entre parenthèses
    | '(' expression ')' {$code = $expression.code ;$exprType = $expression.exprType;}

    // Opérations arithmétiques
    | a=expression op=('*'|'/'|'%') b=expression { $code = evalexpr($a.code,$op.text,$b.code,$a.exprType);$exprType = $a.exprType;}
    | a=expression op=('+'|'-') b=expression { $code = evalexpr($a.code,$op.text,$b.code,$a.exprType);$exprType = $a.exprType;}

    // Valeur entière
    | ENTIER { $code = "PUSHI " + $ENTIER.text + "\n";$exprType = "int";}

    // Valeur décimale
    | DOUBLE { $code = "PUSHF " + $DOUBLE.text + "\n";$exprType = "double";}

    // le cast pour une expression
    |'('TYPE')' a=expression
        {   
            if($TYPE.text.equals("double")){
                if($a.exprType.equals("int")){
                    $code = $a.code;
                    $code += "ITOF\n";
                    $exprType = "double";
                }else if($a.exprType.equals("bool")){
                    $code = $a.code;
                    $code += "ITOF\n";
                    $exprType = "double";
                }
            }
            
            if($TYPE.text.equals("int")){
                if($a.exprType.equals("double")){
                    $code = $a.code;
                    $code += "FTOI\n";
                    $exprType = "int";
                }else if($a.exprType.equals("bool")){
                    $code = $a.code;
                    $exprType = "int";
                }
            }
            if($TYPE.text.equals("bool")){
                if($a.exprType.equals("double")){
                    $code = $a.code;
                    $code += "PUSHF 0.0\n";
                    $code += "FSUP\n";
                    $exprType = "bool";
                }else if($a.exprType.equals("int")){
                    $code = $a.code;
                    $code += "PUSHI 0\n";
                    $code += "SUP\n";
                    $exprType = "bool";
                }  
            }
        }

    // Référence à une variable
    | IDENTIFIANT 
        {   
            VariableInfo varInfo = tablesSymboles.getVar($IDENTIFIANT.text);
            if(varInfo.type.equals("int")){
                if(VariableInfo.Scope.PARAM == varInfo.scope){
                $code = "PUSHL " +varInfo.address+"\n";
                }else {
                    $code = "PUSHG " +varInfo.address+"\n";
                }
                $exprType = varInfo.type;
            }else if(varInfo.type.equals("double")){
                if(VariableInfo.Scope.PARAM == varInfo.scope){
                $code = "PUSHL " +varInfo.address+"\n";
                $code += "PUSHL " +(varInfo.address+1)+"\n";
                }else {
                    $code = "PUSHG " +varInfo.address+"\n";
                    $code += "PUSHG " +(varInfo.address+1) +"\n";
                }
                $exprType = varInfo.type;
            }else if(varInfo.type.equals("bool")){
                if(VariableInfo.Scope.PARAM == varInfo.scope){
                $code = "PUSHL " +varInfo.address+"\n";
                }else {
                    $code = "PUSHG " +varInfo.address+"\n";
                }
                $exprType = varInfo.type;
            }else{
                System.err.println("Type de variable  non pris en charge dans expression");
            }
        }

    //Appel de fonction
     | IDENTIFIANT '(' args ')'
        {
            if(tablesSymboles.getFunction($IDENTIFIANT.text).equals("int")){
                $code ="PUSHI 0\n";
                $code += $args.code;
                $code += "CALL " + $IDENTIFIANT.text + "\n";

                for(int i=0; i < $args.size; i++){
                    $code +="POP\n";
                }
                $exprType = tablesSymboles.getFunction($IDENTIFIANT.text);  
            }else if(tablesSymboles.getFunction($IDENTIFIANT.text).equals("double")){
                $code ="PUSHF 0.0\n";
                $code += $args.code;
                $code += "CALL " + $IDENTIFIANT.text + "\n";

                for(int i=0; i < $args.size; i++){
                    $code +="POP\n";
                }
                $exprType = tablesSymboles.getFunction($IDENTIFIANT.text);  
            }else{ 
                System.err.println("Type de retour de la fonction non pris en charge dans expression");

            }
            
        }
    ;

// Définition de la règle pour les blocs d'instructions
bloc returns [String code]  
@init{ $code = new String(); } 
    : '{'
        
        (instruction { $code += $instruction.code; })*
        NEWLINE*
      '}'  
      NEWLINE*
    ;

// Définition de la règle pour les boucles while
whileInstruction returns [String code]
    @init{String labelStart = newLabel();String labelEnd = newLabel();}
    : 'while''(' condition ')' instruction
        {
            $code = "LABEL "+labelStart+"\n";
            $code += $condition.code;
            $code += "JUMPF "+labelEnd+"\n";        
            $code += $instruction.code;
            $code += "JUMP "+labelStart+"\n";
            $code += "LABEL "+labelEnd+"\n";
        }
    ;

// Définition de la règle pour les boucles for
forInstruction returns [String code]
    @init{String labelStart = newLabel(); String labelEnd = newLabel();}
    : 'for' '(' g=assignation ';' condition ';' d=assignation ')' instruction
        {   
            $code = $g.code;

            $code += "LABEL "+labelStart+"\n";
            $code += $condition.code;
            $code += "JUMPF "+labelEnd+"\n";
            $code += $instruction.code;
            $code += $d.code;
            $code += "JUMP "+labelStart+"\n";
            $code += "LABEL "+labelEnd+"\n";
        }
    ;

// Définition de la règle pour les conditions
condition returns [String code, String condType]
    : 'True' 
        { 
            $code = "PUSHI 1\n"; 
            $condType = "int"; 
        }
    | 'False' 
        { 
            $code = "PUSHI 0\n"; 
            $condType = "int"; 
        }
    | IDENTIFIANT 
        {   
            VariableInfo varInfo = tablesSymboles.getVar($IDENTIFIANT.text);
            if(varInfo.type.equals("bool")){
                if(VariableInfo.Scope.PARAM == varInfo.scope){
                    $code = "PUSHL " +varInfo.address+"\n";
                } else {
                    $code = "PUSHG " +varInfo.address+"\n";
                }
            } else {
                System.err.println("Type de variable non pris en charge dans expression");
            }
            $condType = "int";
        }
    | g=expression op=('<' | '>' | '==' | '<>' | '<=' | '>=' | '&&') d=expression 
        { 
            $code = evalCondition($g.code, $op.text, $d.code, $g.exprType);
            $condType = $g.exprType;
        }
    | '!' a=condition
        { 
            $code = $a.code;
            if ($a.condType.equals("int")) {
                $code += "PUSHI 0\nEQUAL\n";
            } else if ($a.condType.equals("double")) {
                $code += "PUSHF 0.0\nFEQUAL\n";
            } else {
                System.err.println("Type de condition non pris en charge dans condition");
            }
            $condType = "int";
        }
    | gc=condition '&&' dc=condition
        { 
            $code = $gc.code + $dc.code;
            if ($gc.condType.equals("int") && $dc.condType.equals("int")) {
                $code += "MUL\n";
                $condType = "int";
            } else if ($gc.condType.equals("double") || $dc.condType.equals("double")) {
                $code += "FMUL\n";
                $condType = "double";
            } else {
                System.err.println("Type de condition non pris en charge dans condition");
            }
        }
    | gc=condition '||' dc=condition
        { 
            $code = $gc.code + $dc.code;
            if ($gc.condType.equals("int") && $dc.condType.equals("int")) {
                $code += "ADD\nPUSHI 1\nSUPEQ\n";
                $condType = "int";
            } else if ($gc.condType.equals("double") || $dc.condType.equals("double")) {
                $code += "ADD\nPUSHF 1.0\nFSUPEQ\n";
                $condType = "double";
            } else {
                System.err.println("Type de condition non pris en charge dans condition");
            }
        }
    ;

// Définition de la règle pour les structures if-else
ifElse returns [String code]
    : 'if' '(' condition ')' instructionThen=instruction 'else' instructionElse=instruction 
    {
        String labelElse = newLabel();
        String labelEnd = newLabel();
        $code = $condition.code;
        $code += "JUMPF " + labelElse +"\n";
        $code += $instructionThen.code;
        $code += "JUMP " + labelEnd +"\n";
        $code += "LABEL " + labelElse +"\n";
        $code += $instructionElse.code;
        $code += "LABEL " + labelEnd + "\n";
 
    }
    |('if' '(' condition ')' instructionThen=instruction)+
    {
        String labelEnd = newLabel();
        $code = $condition.code;
        $code += "JUMPF " + labelEnd + "\n";
        $code += $instructionThen.code; 
        $code += "LABEL " + labelEnd + "\n";
    }
    ;

// Définition de la règle pour les paramètres de fonction
params
    : TYPE IDENTIFIANT
        {
           tablesSymboles.addParam($IDENTIFIANT.text,$TYPE.text);
        }
        ( ',' TYPE IDENTIFIANT
            {
               tablesSymboles.addParam($IDENTIFIANT.text,$TYPE.text);
            }
        )*
    ;

// Définition de la règle pour les fonctions
fonction returns [ String code ]
@init{tablesSymboles.enterFunction();}
@after{tablesSymboles.exitFunction();}
    : 'fun'  IDENTIFIANT '('  params ? ')'  '->' TYPE
        {
            tablesSymboles.addFunction($IDENTIFIANT.text, $TYPE.text);
            $code = "LABEL " + $IDENTIFIANT.text + "\n";
        }
        '{'  

	    NEWLINE?

        (declaration { $code += $declaration.code; })*

        NEWLINE*

        (  instruction  {$code += $instruction.code;} )*

        '}' 

            NEWLINE*

        {$code += "RETURN\n";}
    ;

finInstruction : ( NEWLINE | ';' )+ ;

// lexer
RETURN: 'return';
TYPE : 'int' | 'double'|'bool';
IDENTIFIANT : [a-zA-Z]+('0'..'9')*;
NEWLINE : '\r'? '\n';
WS :   (' '|'\t')+ -> skip  ;
ENTIER : ('0'..'9')+  ;
DOUBLE : ('0'..'9')+'.'('0'..'9')*;
COMMENTAIRE : '//' ~[\r\n]* -> skip ;
COMMENTAIRELIGNE : '/*' .*? '*/' -> skip ;
UNMATCH : . -> skip ;

