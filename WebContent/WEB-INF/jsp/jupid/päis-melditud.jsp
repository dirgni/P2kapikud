<div id="pealmine">
	<div id="pealmine_vasakpoolne">
		<div id="logo" class="logo-meld"></div>
		<!-- Asendatud top-navi'ga
		<div id="navigatsioon">
			TODO Navigatsioon
			<a href="tabel.html">Tabel</a>
		</div>  -->
		
		<div id="user_window">
			<div id="user_Upper">
<!-- 				<div id="user_PhotoBox"> -->
					
<!-- 				</div> -->
				
				<div id="user_DataBox">
					<div id="user_Prof">
						Tere, ${klient.roll}
					</div>
					<div id="user_FullName">
						${klient.eesnimi} ${klient.perenimi}
					</div>
<!-- 					<div id="user_ArtCounter"> -->
<!-- 						48 artiklit -->
<!-- 					</div> -->
				</div>
			</div>	
<!-- 			<div id="user_Bottom"> -->
<!-- 				Redigeeri -->
<!-- 			</div> -->
		</div>
		
	</div> <!-- pealmine_vasakpoolne -->
	
	<div id="pealmine_parempoolne">
		<div id="buttons">
			<div id="LOGIN-button">
				<form action="logout">
				    <button id="logout" type="submit" value="Välju">Välju</button>
				</form>
		 	</div>
		 	<div id="RSS-button" onclick="makeVisible('RSS')"></div>
		</div>
		<div id="otsing">
			<form action="otsing">
		 		<input type="text" name="otsing" placeholder="Sisesta otsisõna">
		 	</form>
		</div> <!-- otsing -->
	</div> <!-- pealmine_parempoolne -->
</div>