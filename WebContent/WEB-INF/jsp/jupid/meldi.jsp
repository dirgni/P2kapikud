

<div id="Meldi" class="invisible">
	<div id="meldi_container">
		<div id="navi-buttons">
			<button onclick="showMeldi();"> Meldi </button>
			<button onclick="showRegistreeru();"> Registreeru </button>
		</div>
		<div id="meld">
			<h3> Meldi </h3>
			<form id="meldi-vorm" method="post" action="login">
				Kasutajanimi: <input class="input-field" name="k-nimi" placeholder="Kasutajanimi" type="text">
		 		Parool: <input class="input-field" name="pwd" placeholder="******" type="password">
		 		<span id="meldi-vorm-nupud" class="hidden-nupud">
					<button onclick="makeHidden('RSS');"> Meldi </button>
					<button onclick="makeHidden('RSS');"> Katkesta </button>
				</span>
			</form>
		</div>
		<div id="register">
				<h3> Registreeru </h3>
				<form id="registreeru-vorm" method="post" action="register">
					Kasutajanimi: <input class="input-field" name="k-nimi" placeholder="Kasutajanimi" type="text">
			 		Parool: <input class="input-field" name="pwd" placeholder="******" type="password">
			 		Parool uuesti: <input class="input-field" name="pwd" placeholder="******" type="password">
			 		<span id="meldi-vorm-nupud" class="hidden-nupud">
						<button onclick="makeHidden('RSS');"> Registreeru </button>
						<button onclick="makeHidden('RSS');"> Katkesta </button>
					</span>
				</form>
		</div>
	</div>
	
</div>