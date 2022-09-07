package week9;

public class PolyDriver {

    /*
    public static String[] strArrMethod(String[] arr){
        String[] result = new String[arr.length];
        int counter = 0;
        for (int j = 0; j < arr.length; j++){
            String sm = arr[j];
            for (int k = j + 1; k < arr.length; k++){
                if (arr[k].length() < sm.length()){
                    sm = arr[k]; // Line 12
                    counter++;
                }
            }
            result[j] = sm;
        }
        System.out.println(counter);
        return result;

        
    }
    */
    public static void main(String[] args){
        /*// not polymorphism - reference is same as object
        Animal animal = new Animal();
        animal.makeSound();
        Dog dog = new Dog();
        dog.makeSound();
        dog.chaseTail();
        Cat cat = newCat();
        cat.makeSound();
        

        Animal animal = new Cat();
        animal.makeSound();
        animal = new Dog();
        animal.makeSound();
        ((Dog)animal).chaseTail();
        System.out.println(Beverage.getStatus());
        */      

       A obj = new B();
       obj.showValue();

       double A = 7.0;
       int B = 6;
       double sum = A + B;
        System.out.println(sum);
    }    
}
