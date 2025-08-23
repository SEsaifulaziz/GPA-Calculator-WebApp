function generateCourseFields() {
    const numCourses = document.getElementById('numCourses').value;
    const courseFields = document.getElementById('courseFields');
    courseFields.innerHTML = '';
    
    if (numCourses > 0) {
        courseFields.innerHTML = '<h3>Course Details</h3>';
        
        for (let i = 1; i <= numCourses; i++) {
            courseFields.innerHTML += `
                <div class="course-field">
                    <h4>Course ${i}</h4>
                    <div class="form-group">
                        <label for="courseName${i}">Course Name:</label>
                        <input type="text" id="courseName${i}" name="courseName${i}" required>
                    </div>
                    <div class="form-group">
                        <label for="credits${i}">Credit Hours:</label>
                        <input type="number" id="credits${i}" name="credits${i}" min="1" max="10" required>
                    </div>
                    <div class="form-group">
                        <label for="marks${i}">Marks (0-100):</label>
                        <input type="number" id="marks${i}" name="marks${i}" min="0" max="100" required>
                    </div>
                </div>
            `;
        }
    }
}

// Client-side validation
document.getElementById('courseForm').addEventListener('submit', function(e) {
    const numCourses = document.getElementById('numCourses').value;
    
    for (let i = 1; i <= numCourses; i++) {
        const marks = document.getElementById('marks' + i);
        const credits = document.getElementById('credits' + i);
        
        if (marks && (marks.value < 0 || marks.value > 100)) {
            alert('Marks must be between 0-100 for Course ' + i);
            e.preventDefault();
            return;
        }
        
        if (credits && credits.value <= 0) {
            alert('Credits must be positive for Course ' + i);
            e.preventDefault();
            return;
        }
    }
});