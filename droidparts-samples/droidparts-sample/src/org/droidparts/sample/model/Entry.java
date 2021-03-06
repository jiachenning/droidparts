/**
 * Copyright 2014 Alex Yanchenko
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 */
package org.droidparts.sample.model;

import java.util.Date;

import org.droidparts.annotation.serialize.JSON;
import org.droidparts.annotation.sql.Column;
import org.droidparts.annotation.sql.Table;
import org.droidparts.model.Entity;

@Table(name = "entries")
public class Entry extends Entity {
	private static final long serialVersionUID = 1L;

	@JSON(key = "date_created")
	@Column
	public Date created;

	@JSON
	@Column
	public String name;

}
