#include <stdio.h>

int main() {
    float math[3], physics[3], chemistry[3];
    float avg_math, avg_physics, avg_chemistry;
    float overall_avg;

    // Input marks for Math
    printf("Enter marks for Math:\n");
    printf("Course Work: ");
    scanf("%f", &math[0]);
    printf("Mid Term: ");
    scanf("%f", &math[1]);
    printf("End of Term: ");
    scanf("%f", &math[2]);

    // Input marks for Physics
    printf("\nEnter marks for Physics:\n");
    printf("Course Work: ");
    scanf("%f", &physics[0]);
    printf("Mid Term: ");
    scanf("%f", &physics[1]);
    printf("End of Term: ");
    scanf("%f", &physics[2]);

    // Input marks for Chemistry
    printf("\nEnter marks for Chemistry:\n");
    printf("Course Work: ");
    scanf("%f", &chemistry[0]);
    printf("Mid Term: ");
    scanf("%f", &chemistry[1]);
    printf("End of Term: ");
    scanf("%f", &chemistry[2]);

    // Calculate average for each subject
    avg_math = (math[0] + math[1] + math[2]) / 3;
    avg_physics = (physics[0] + physics[1] + physics[2]) / 3;
    avg_chemistry = (chemistry[0] + chemistry[1] + chemistry[2]) / 3;

    // Calculate overall average
    overall_avg = (avg_math + avg_physics + avg_chemistry) / 3;

    // Output the results
    printf("\nAverage marks for each subject:\n");
    printf("Math: %.2f\n", avg_math);
    printf("Physics: %.2f\n", avg_physics);
    printf("Chemistry: %.2f\n", avg_chemistry);
    printf("\nOverall average marks: %.2f\n", overall_avg);

    return 0;
}
