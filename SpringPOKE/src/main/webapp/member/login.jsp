<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>CodePen - Sign Up/Sign In Responsive form</title>
<link rel="stylesheet" href="../member/style.css">
<script type="text/javascript" src="http://unpkg.com/vue@3"></script>
<script type="text/javascript" src="http://unpkg.com/axios/dist/axios.min.js"></script>
<style type="text/css">
body {
	margin: 0;
	padding: 0;
	background: url('dust.png') no-repeat center center fixed;
	background-size: cover;
	font-family: Arial, sans-serif;
}

.login {
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
}

.login__create, .login__find {
	left: -4rem;
}
</style>
<link href='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css' rel='stylesheet'>
</head>
<body>
	<div class="login">
		<div class="login__content">
			<div class="login__forms">
				<!-- 로그인 페이지 -->
				<form action="" class="login__register" id="login-in">
					<h1 class="login__title">Sign In</h1>
					<div class="login__box">
						<i class='bx bx-user login__icon'></i> <input type="text" placeholder="Username" class="login__input" id="id" v-model="id" v-on:keyup.enter="login">
					</div>
					<div class="login__box">
						<i class='bx bx-lock login__icon'></i> <input type="password" placeholder="Password" class="login__input" id="pwd" v-model="pwd" v-on:keyup.enter="login">
					</div>
					<button type="button" class="login__button" v-on:click="login">Sign In</button>

					<div>
						<span class="login__signin login__signin--signup" id="forgot">Forgot Account? </span>&nbsp;<span class="login__signin login__signin--signup"
							id="forgotPwd">Forgot Password? </span><br> <span class="login__account login__account--account">Don't Have an Account?</span> <span
							class="login__signin login__signin--signup" id="sign-up">Sign Up</span>
					</div>
				</form>
				<!-- 로그인페이지 종료 -->
				<!--         create account form -->
				<div class="login__create none" id="login-up">
					<h1 class="login__title">Create Account</h1>
					<div class="login__box">
						<i class='bx bx-face login__icon'></i> <input type="text" placeholder="Username" class="login__input" id="name" required>
					</div>

					<div class="login__box">
						<i class='bx bx-user login__icon'></i> <input type="text" placeholder="ID" class="login__input" id="signUpId"> <input type="button"
							value="중복확인" id="idCheck">
						<img src="check.png" width="20px" id="idIcon" height="20px" style="background: none; display: none;">
					</div>

					<div class="login__box">
						<i class='bx bx-ghost login__icon'></i> <input type="text" placeholder="Nick name" class="login__input" id="nick"> <input type="button"
							value="중복확인" id="nickCheck">
						<img src="check.png" width="20px" id="nickIcon" height="20px" style="background: none; display: none;">
					</div>

					<div class="login__box">
						<i class='bx bx-lock login__icon'></i> <input type="text" placeholder="Password" class="login__input" id="signUppwd">
					</div>

					<div class="login__box">
						<i class='bx bx-lock login__icon'></i> <input type="text" placeholder="Confirm Password" class="login__input" id="pwdCheck">
						<p style="margin: 0 auto;">
							<font size="1px" id="pwdState">&nbsp;</font>
						</p>
					</div>

					<div class="login__box">
						<i class='bx bx-phone login__icon'></i> <input type="text" placeholder="Phone" class="login__input" readonly>
						<div class="phone-container">
							<select name="phone" class="phone-prefix" style="margin-right: 6px;" id="phone_first">
								<option value="">없음</option>
								<option value="02">02</option>
								<option value="010">010</option>
								<option value="011">011</option>
							</select> <input type="text" placeholder="Phone" class="phone-input" style="margin-right: 6px;" id="phone_second" readonly maxlength="4"> <input
								type="text" placeholder="Phone" class="phone-input" id="phone_third" readonly maxlength="4"> <input type="button" value="중복확인"
								id="phoneCheck">
							<img src="check.png" width="20px" id="phoneIcon" height="20px" style="background: none; display: none;">
						</div>
					</div>

					<div class="login__box">
						<i class='bx bx-cake login__icon'></i> <input type="text" placeholder="Birth" class="login__input" readonly> <input type="date" required
							id="birth">
					</div>
					<div class="login__box" style="text-align: right;" id="sexCheck">
						<i class='bx bx-heart login__icon'></i> <input type="text" placeholder="Gender" class="login__input" readonly> <label
							class="login__input"> <input type="radio" value="남자" name="sex" id="sex" checked> 남자
						</label> <label class="login__input"> <input type="radio" value="여자" name="sex" id="sex"> 여자
						</label>
					</div>

					<div class="login__box">
						<i class='bx bx-at login__icon'></i> <input type="text" placeholder="Email" class="login__input" id="email"> <input type="button"
							value="중복확인" id="emailCheck">
						<img src="check.png" width="20px" id="emailIcon" height="20px" style="background: none; display: none;">
					</div>

					<div class="login__box">
						<i class='bx bx-mail-send login__icon'></i> <input type="text" placeholder="post" class="login__input" readonly="readonly" id="post"> <input
							type="button" value="우편번호 찾기" id="postBtn" required>
					</div>
					<div class="login__box">
						<i class='bx bx-map login__icon'></i> <input type="text" placeholder="addr" class="login__input" readonly="readonly" id="addr1">
					</div>
					<div class="login__box">
						<i class='bx bx-map login__icon'></i> <input type="text" placeholder="addr" class="login__input" id="addr2">
					</div>


					<a href="#" class="login__button" id="signUpBtn">Sign Up</a>

					<div>
						<span class="login__account login__account--account">Already have an Account?</span> <span class="login__signup login__signup--signup"
							id="sign-in">Sign In</span>
					</div>

				</div>
				<!-- 아이디찾기 페이지 -->
				<div class="login__find none" id="find-account">
					<h1 class="login__title">Find Account</h1>
					<div class="login__box" id="findType">
						<i class='bx bx-search login__icon'></i> <input type="text" placeholder="type" class="login__input" readonly> <label
							class="login__input"> <input type="radio" value="1" name="type" id="type"> 전화번호
						</label> <label class="login__input"> <input type="radio" value="2" name="type" id="type"> 이메일
						</label>
					</div>
					<div class="login__box none" id="findPhone">
						<i class='bx bx-phone login__icon'></i> <input type="text" placeholder="Phone" class="login__input" readonly>
						<div class="phone-container">
							<select name="phone1" class="phone-prefix" style="margin-right: 6px;" id="phone1">
								<option value="02">02</option>
								<option value="010">010</option>
								<option value="011">011</option>
							</select> <input type="text" placeholder="Phone" class="phone-input" style="margin-right: 6px;" id="phone2" maxlength="4"> <input type="text"
								placeholder="Phone" class="phone-input" id="phone3" maxlength="4">
						</div>
					</div>
					<div class="login__box none" id="findEmail">
						<i class='bx bx-search login__icon'></i> <input type="text" placeholder="Email" class="login__input" id="findEmailData">
					</div>
					<div class="none" id="findBtn">
						<span style="cursor: pointer;" class="login__button">Find</span>
					</div>
					<div id="findResultDiv none">
						<span id="findResult" class="login__account login__account--account" style="font-size: 25px;"></span>
					</div>
					<div>
						<span class="login__account login__account--account">Already have an Account?</span> <span class="login__signup login__signup--signup"
							id="returnLogin">Sign In</span>
					</div>
				</div>
				<!-- 비밀번호찾기 페이지 -->
				<div class="login__find none" style="height: 360px !important;" id="find-Pwd">
					<h1 class="login__title">Find Password</h1>
					<div class="login__box" id="findIdPwd">
						<i class='bx bx-user login__icon'></i> <input type="text" placeholder="ID" class="login__input" id="idPwd">
					</div>
					<div class="login__box" id="findTypePwd">
						<i class='bx bx-search login__icon'></i> <input type="text" placeholder="type" class="login__input" readonly> <label
							class="login__input"> <input type="radio" value="1" name="typePwd" id="typePwd"> 전화번호
						</label> <label class="login__input"> <input type="radio" value="2" name="typePwd" id="typePwd"> 이메일
						</label>
					</div>
					<div class="login__box none" id="findPhonePwd">
						<i class='bx bx-phone login__icon'></i> <input type="text" placeholder="Phone" class="login__input" readonly>
						<div class="phone-container">
							<select name="phone1Pwd" class="phone-prefix" style="margin-right: 6px;" id="phone1Pwd">
								<option value="02">02</option>
								<option value="010">010</option>
								<option value="011">011</option>
							</select> <input type="text" placeholder="Phone" class="phone-input" style="margin-right: 6px;" id="phone2Pwd" maxlength="4"> <input type="text"
								placeholder="Phone" class="phone-input" id="phone3Pwd" maxlength="4">
						</div>
					</div>
					<div class="login__box none" id="findEmailPwd">
						<i class='bx bx-search login__icon'></i> <input type="text" placeholder="Email" class="login__input" id="findEmailDataPwd">
					</div>
					<div class="none" id="findBtnPwd">
						<span style="cursor: pointer;" class="login__button">Find</span>
					</div>
					<div id="findResultDivPwd none">
						<span id="findResultPwd" class="login__account login__account--account" style="font-size: 25px;"></span>
					</div>
					<div>
						<span class="login__account login__account--account">Already have an Account?</span> <span class="login__signup login__signup--signup"
							id="returnLoginPwd">Sign In</span>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- partial -->
	<script>
	const app=Vue.createApp({
		data(){
			return{
			id:'',
			pwd:''
			}
		},
		methods:{
			login(){
				console.log(this.id)
				console.log(this.pwd)
				axios.get('../member/loginCheck.do', {
					params:{
						id:this.id,
						pwd:this.pwd
					}
				}).then(response=>{
					console.log(response.data.result)
				})
			}
		}
	})
	app.mount('#login-in')
	</script>

	<script type="text/javascript">

</script>
</body>
</html>
