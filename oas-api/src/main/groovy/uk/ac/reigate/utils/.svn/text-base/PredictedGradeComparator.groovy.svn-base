package uk.ac.reigate.utils

import uk.ac.reigate.oas.domain.PredictedGrade

class PredictedGradeComparator implements Comparator {
    
    @Override
    public int compare(Object o1, Object o2) {
        PredictedGrade p1 = (PredictedGrade) o1
        PredictedGrade p2 = (PredictedGrade) o2
        if (p1.qualification.equals(p2.qualification) && p1.yearOfExamination == p2.yearOfExamination) {
            return 0;
        }
        return 1;
    }
}
