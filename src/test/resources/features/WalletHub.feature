Feature: Post wallet hub review
  I want to use this feature for posting review on wallet hub website

  @wh
  Scenario: Login to WalletHub and Post review
    Given Launch browser with url "wallethub.url"
    When User log in with UserName "user.email" and password "password"
		And select review ratings and Post review
		Then validate if review posted successfully
		When User navigates to profile page
		Then review should be posted in feeds section of profile page
		And close the browser