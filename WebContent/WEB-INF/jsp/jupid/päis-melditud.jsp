
<div id="pealmine">
	<div id="pealmine_vasakpoolne">
		<div id="logo" class="logo-meld"></div>
		<div id="user_window">
			<div id="user_Upper">
				<div id="user_DataBox">
					<div id="user_Prof">
						Tere, ${klient.roll}
					</div>
					<div id="user_FullName">
						${klient.eesnimi} ${klient.perenimi}
					</div>
				</div>
			</div>	
		</div>
	</div> <!-- pealmine_vasakpoolne -->
	
	<div id="pealmine_parempoolne">
		<div id="buttons">
			<div id="LOGIN-button">
				<form action="logout">
				    <button id="logout" type="submit" value="V�lju">V�lju</button>
				</form>
		 	</div>
		</div>
		<div id="otsing">
			<form action="otsing">
		 		<input type="text" name="otsing" placeholder="Sisesta otsis�na">
		 	</form>
		</div> <!-- otsing -->
	</div> <!-- pealmine_parempoolne -->
</div>