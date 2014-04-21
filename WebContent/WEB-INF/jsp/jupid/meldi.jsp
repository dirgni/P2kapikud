

<div id="Meldi" class="invisible">
	<div id="meldi_container">
		<div id="navi-buttons">
			<button onclick="showMeldi();">Meldi</button>
			<button onclick="showRegistreeru();">Registreeru</button>
		</div>
		<div id="meld">
			<h3>Meldi</h3>
			<div id="meldi_integr">
				<form id="meldi-vorm" method="post" action="login">
					Kasutajanimi: <input class="input-field" name="k-nimi"
						placeholder="Kasutajanimi" type="text"> Parool: <input
						class="input-field" name="pwd" placeholder="******" type="password">
					<span id="meldi-vorm-nupud" class="hidden-nupud">
						<button onclick="makeHidden('Meldi');">Meldi</button>
						<button onclick="makeHidden('Meldi');">Katkesta</button>
					</span>
				</form>
			</div>
			<div id="meldi_väline">
				<div class="fb-login-button" data-max-rows="1" data-size="large" data-show-faces="true" data-auto-logout-link="false"></div>
			</div>
		</div>
		<div id="register">
			<h3>Registreeru</h3>
			<form id="registreeru-vorm" method="post" action="register">
				Eesnimi: <input class="input-field" name="e-nimi"
					placeholder="Eesnimi" type="text"> Perenimi: <input
					class="input-field" name="p-nimi" placeholder="Perenimi"
					type="text"> Kasutajanimi: <input class="input-field"
					name="k-nimi" placeholder="Kasutajanimi" type="text">
				Parool: <input class="input-field" name="pwd" placeholder="******"
					type="password"> Parool uuesti: <input class="input-field"
					name="pwd2" placeholder="******" type="password"> <span
					id="meldi-vorm-nupud" class="hidden-nupud">
					<button onclick="makeHidden('Meldi');">Registreeru</button>
					<button onclick="makeHidden('Meldi');">Katkesta</button>
				</span>
			</form>
		</div>
	</div>

</div>