class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

		//"/"(view:"/index")
        "/"(view:"/book/list")
		"500"(view:'/error')
	}
}
