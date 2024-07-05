var quizData = [
    {
        number: 1,
        name: "문제1 내용",
        choices: ["보기 1", "보기 2", "보기 3", "보기 4"]
    },
    {
        number: 2,
        name: "문제2 내용",
        choices: ["보기 1", "보기 2", "보기 3", "보기 4"]
    },
    {
        number: 3,
        name: "문제3 내용",
        choices: ["보기 1", "보기 2", "보기 3", "보기 4"]
    },
    {
        number: 4,
        name: "문제4 내용",
        choices: ["보기 1", "보기 2", "보기 3", "보기 4"]
    }
];

var currentQuestionIndex = 0;
var filteredQuizData = [];

function confirmQuiz() {
    var selectedCount = document.querySelector('input[name="quiz-count"]:checked').value;
    filteredQuizData = quizData.slice(0, selectedCount); // 선택된 개수만큼 필터링
    currentQuestionIndex = 0;
    showCurrentQuestion(); // 첫 번째 문제 보여주기
    toggleModal('quiz-modal');
}

function showCurrentQuestion() {
    var quizDisplay = document.getElementById('content-display');
    var currentQuestion = filteredQuizData[currentQuestionIndex];

    var html = '<div class="quiz-item">';
    html += '<div class="question-number">문제 ' + currentQuestion.number + '</div>';
    html += '<div class="question-divider"></div>';
    html += '<div class="question-name">' + currentQuestion.name + '</div>';

    // 보기 출력
    currentQuestion.choices.forEach(function(choice, index) {
        html += '<div class="radio-buttons">';
        html += '<label><input type="radio" name="selected-question" value="' + choice + '">' + choice + '</label>';
        html += '</div>';
    });

    html += '</div>';

    // 네비게이션 버튼
    html += '<div class="navigation-buttons">';
    if (currentQuestionIndex > 0) {
        html += '<button onclick="showPreviousQuestion()">이전</button>';
    }
    if (currentQuestionIndex < filteredQuizData.length - 1) {
        html += '<button onclick="showNextQuestion()">다음</button>';
    }
    html += '</div>';

    quizDisplay.innerHTML = html;
}

function showPreviousQuestion() {
    if (currentQuestionIndex > 0) {
        currentQuestionIndex--;
        showCurrentQuestion();
    }
}

function showNextQuestion() {
    if (currentQuestionIndex < filteredQuizData.length - 1) {
        currentQuestionIndex++;
        showCurrentQuestion();
    }
}

function toggleModal(modalId) {
    var modal = document.getElementById(modalId);
    if (modal.style.display === "block") {
        modal.style.display = "none";
    } else {
        modal.style.display = "block";
    }
}

function startQuiz() {
    toggleModal('quiz-modal');
}

function uploadFile() {
    var fileInput = document.getElementById("file-input");
    var file = fileInput.files[0];
    console.log("Uploaded file:", file.name);
}

function showSummary() {
    document.getElementById('content-display').innerHTML = '요약 내용 표시';
}

function review() {
    document.getElementById('content-display').innerHTML = '복습 시작';
}

function findFavorites() {
    alert('즐겨찾기 기능');
}

function showAnswers() {
    alert('오답 기능');
}
