//Min Hang Lee CSE320 Assignment#1 
#include <stdio.h>
#include <stdbool.h>
#include <stdint.h>

void cvt(unsigned int decimal, unsigned int base, char digits[]){
    int remainder;
    int index = 0;
    
    while (decimal > 0){

        remainder = decimal % base;

        if (remainder > 9){
            remainder -= 10;
            remainder += 'A';
        }

        else {
            remainder += '0';
        }

        digits[index++] = remainder;
        decimal /= base;
    }

    //print digits from backwards
    printf("The result is : ");

    for (int i = index; i >= 0; i--){
        printf("%c", digits[i]);
    }

    printf("\n");
}

void prompt(unsigned int decimal, unsigned int base, char digits[]){
    while (true){
        printf("Enter a number in decmial (0 ~ 4294967295) that you want to convert : ");
        scanf("%u", &decimal);
        printf("Enter the base(2 ~ 16) to which the number should be converted : ");
        scanf("%u", &base);

        if (base < 2 || base > 16){ // Error Checking for base
            printf("=====ERROR : Base must be in 2 ~ 16 range=====\n");
            break;
        }

        else {  //Keep Going
            cvt(decimal, base, digits);
            printf("-----END of the Program-----\n");
            break;
        }   
        
    }   // end of prompt
}
int main(void){
    unsigned int decimal, base;
    char digits[32];
    prompt(decimal, base, digits);
    return 0;
}