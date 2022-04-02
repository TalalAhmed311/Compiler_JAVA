package com.tokens;
import java.util.ArrayList;
import java.util.Arrays;



public class SyntaxAnalyzer {

	static int i = 0;
	ArrayList<ArrayList<String>> tokenSet = new ArrayList<ArrayList<String>>();
	
	 public SyntaxAnalyzer() throws Exception {
			// TODO Auto-generated constructor stub
		 
		    tokenSet = new Lexical_Analyzer().getTokens();
		    ArrayList<String> token=new ArrayList<String>(Arrays.asList("$","$","end"));
			
			tokenSet.add(token);
		
		 
		 if(S()) {
			 
			 System.out.println("Valid Syntax...");
	
		 } else {
			 
			 System.out.println("Invalid Syntax...");
		 }
		 
		 
	}
	

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		new SyntaxAnalyzer();
//		System.out.println("hel");
		
	}
	
	
	private boolean S() {
		
		if(def()) {
			
			if(tokenSet.get(i).get(0).equals ("public")) {
				i++;
				
				if(tokenSet.get(i).get(0).equals ("class")) {
					i++;
					
					if(tokenSet.get(i).get(0).equals ("ID")) {
						i++;
						
						if(inherit()) {
							
							if(tokenSet.get(i).get(0).equals ("{")) {
								i++;
								
								if(S_dash()) {
									System.out.println("out");
									if(tokenSet.get(i).get(0).equals ("}")) {
										
										i++;
										
										if(def()) {
											
											return true;
										}
									}
								}
							}
							
						}
					}
				}
			}
		}
		
		return false;
	}
	
	private boolean S_dash() {

		if(tokenSet.get(i).get(0).equals ("public")) {
			i++;
			
			if(S_doubledash()) {
				System.out.println("out");
				return true;
			}
		}
		else if(tokenSet.get(i).get(0).equals ("private")) {
			i++;
			
			if(c_body3()) {
				
				if(tokenSet.get(i).get(0).equals ("public")) {
					i++;
					
					if(tokenSet.get(i).get(0).equals ("static")) {
						i++;
						
						if(tokenSet.get(i).get(0).equals ("void")) {
							i++;
							
							if(tokenSet.get(i).get(0).equals ("main")) {
								i++;
								
								if(tokenSet.get(i).get(0).equals ("(")) {
									i++;
									
									if(tokenSet.get(i).get(0).equals (")")) {
										i++;
										
										if(tokenSet.get(i).get(0).equals ("{")) {
											i++;
											
											if(MST()) {
												
												if(tokenSet.get(i).get(0).equals ("}")) {
													i++;
													
													if(c_body()) {
														
														return true;
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		else if(c_body3()) {
//				System.out.println("token: "+tokenSet.get(i).get(0));
//				if(tokenSet.get(i).get(0).equals ("public")) {
//					i++;
//					
//					if(tokenSet.get(i).get(0).equals ("static")) {
//						i++;
//						
//						if(tokenSet.get(i).get(0).equals ("void")) {
//							i++;
//							
//							if(tokenSet.get(i).get(0).equals ("main")) {
//								i++;
//								
//								if(tokenSet.get(i).get(0).equals ("(")) {
//									i++;
//									
//									if(tokenSet.get(i).get(0).equals (")")) {
//										i++;
//										
//										if(tokenSet.get(i).get(0).equals ("{")) {
//											i++;
//											
//											if(MST()) {
//												
//												if(tokenSet.get(i).get(0).equals ("}")) {
//													i++;
//													
//													if(c_body()) {
//														
//														return true;
//													}
//												}
//											}
//										}
//									}
//								}
//							}
//						}
//					}
//				}
			
				  return true;
			}else if(tokenSet.get(i).get(0).equals("}")){
			    return true;
		    }
		
		
		return false;
	}
	
	private boolean S_doubledash() {
		
		if(tokenSet.get(i).get(0).equals ("const")) {
			i++;
			
			if(CST3()) {
				
				if(S_dash()) {
					
					return true;
				}
			}
		}
		else if(tokenSet.get(i).get(0).equals ("DT")) {
			i++;
			
			if(CST4()) {
				
				if(S_dash()) {
					
					return true;
				}
			}
		}
		else if(tokenSet.get(i).get(0).equals ("ID")) {
			i++;
			
			if(CST_doubledash()) {
				
				if(S_dash()) {
					
					return true;
				}
			}
		}
		else if(tokenSet.get(i).get(0).equals ("String")) {
			i++;
			
			if(CST6()) {
				
				if(S_dash()) {
					
					return true;
				}
			}
		}
		else if(tokenSet.get(i).get(0).equals ("var")) {
			i++;
			
			if(CST6()) {
				
				if(S_dash()) {
					
					return true;
				}
			}
		}
		else if(tokenSet.get(i).get(0).equals ("void")) {
			i++;
			
			if(tokenSet.get(i).get(0).equals ("ID")) {
				i++;
				
				if(tokenSet.get(i).get(0).equals ("(")) {
					i++;
					
					if(args()) {
						
						if(tokenSet.get(i).get(0).equals (")")) {
							i++;
							System.out.println("done");
							if(fun2()) {
								System.out.println("out from fun2");
								if(S_dash()) {
									System.out.println("out from s_dash");
									return true;
								}
							}
						}
					}
				}
			}
		}
		else if(tokenSet.get(i).get(0).equals ("class")) {
			i++;
			
			if(tokenSet.get(i).get(0).equals ("ID")) {
				i++;
				
				if(inherit()) {
					
					if(tokenSet.get(i).get(0).equals ("{")) {
						i++;
						
						if(c_body()) {
							
							if(tokenSet.get(i).get(0).equals ("}")) {
								i++;
								
								if(S_dash()) {
									
									return true;
								}
							}
						}
					}
				}
			}
		}
		else if(tokenSet.get(i).get(0).equals ("interface")) {
			i++;
			System.out.println("interface");
			if(tokenSet.get(i).get(0).equals ("ID")) {
				i++;
				
				if(inherit()) {
					
					if(tokenSet.get(i).get(0).equals ("{")) {
						i++;
						
						if(int_body()) {
							if(tokenSet.get(i).get(0).equals ("}")) {
								i++;
								
								if(S_dash()) {
									
									return true;
								}
							}
						}
					}
				}
			}
		}
		else if(tokenSet.get(i).get(0).equals ("enum")) {
			i++;
			System.out.println("enum come");
			if(tokenSet.get(i).get(0).equals ("ID")) {
				i++;
				
				if(tokenSet.get(i).get(0).equals ("{")) {
					i++;
					
					if(enum_body()) {
						
						if(tokenSet.get(i).get(0).equals ("}")) {
							i++;
							
							if(S_dash()) {
								
								return true;
							}
						}
					}
				}
			}
		}
		
		else if(tokenSet.get(i).get(0).equals ("static")) {
			i++;
			
			if(S_tripledash()) {
				
				return true;
			}
		}
		else if(tokenSet.get(i).get(0).equals ("abstract")) {
			i++;
			
			if(c_body2()) {
				
				if(tokenSet.get(i).get(0).equals ("public")) {
					i++;
					
					if(tokenSet.get(i).get(0).equals ("static")) {
						i++;
						
						if(tokenSet.get(i).get(0).equals ("void")) {
							i++;
							
							if(tokenSet.get(i).get(0).equals ("main")) {
								i++;
								
								if(tokenSet.get(i).get(0).equals ("(")) {
									i++;
									
									if(tokenSet.get(i).get(0).equals (")")) {
										i++;
										
										if(tokenSet.get(i).get(0).equals ("{")) {
											i++;
											
											if(MST()) {
												
												if(tokenSet.get(i).get(0).equals ("}")) {
													i++;
													
													if(c_body()) {
														
														return true;
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		else if(tokenSet.get(i).get(0).equals ("sealed")) {
					i++;
				
					if(c_body2()) {
						
						if(tokenSet.get(i).get(0).equals ("public")) {
							i++;
							
							if(tokenSet.get(i).get(0).equals ("static")) {
								i++;
								
								if(tokenSet.get(i).get(0).equals ("void")) {
									i++;
									
									if(tokenSet.get(i).get(0).equals ("main")) {
										i++;
										
										if(tokenSet.get(i).get(0).equals ("(")) {
											i++;
											
											if(tokenSet.get(i).get(0).equals (")")) {
												i++;
												
												if(tokenSet.get(i).get(0).equals ("{")) {
													i++;
													
													if(MST()) {
														
														if(tokenSet.get(i).get(0).equals ("}")) {
															i++;
															
															if(c_body()) {
																
																return true;
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
			}else if(tokenSet.get(i).get(0).equals("}")) {
				return false;
			}
		
		return false;
	}
	
	private boolean S_tripledash() {
		
		if(tokenSet.get(i).get(0).equals ("const")) {
			i++;
			
			if(CST3()) {
				
				if(S_dash()) {
					
					return true;
				}
			}
		}
		else if(tokenSet.get(i).get(0).equals ("DT")) {
			i++;
			
			if(CST4()) {
				
				if(S_dash()) {
					
					return true;
				}
			}
		}
		else if(tokenSet.get(i).get(0).equals ("ID")) {
			i++;
			
			if(CST5()) {
				
				if(S_dash()) {
					
					return true;
				}
			}
		}
		else if(tokenSet.get(i).get(0).equals ("String")) {
			i++;
			
			if(CST6()) {
				
				if(S_dash()) {
					
					return true;
				}
			}
		}
		else if(tokenSet.get(i).get(0).equals ("var")) {
			i++;
			
			if(CST6()) {
				
				if(S_dash()) {
					
					return true;
				}
			}
		}
		else if(tokenSet.get(i).get(0).equals ("void")) {
			i++;
			
			if(S1()) {
				
				return true;
			}
		}
		else if(tokenSet.get(i).get(0).equals ("class")) {
				i++;
				
				if(tokenSet.get(i).get(0).equals ("ID")) {
					i++;
					
					if(inherit()) {
						
						if(tokenSet.get(i).get(0).equals ("{")) {
							i++;
							
							if(c_body()) {
								
								if(tokenSet.get(i).get(0).equals ("}")) {
									i++;
									
									if(S_dash()) {
										
										return true;
									}
								}
							}
						}
					}
				}
			}else if(tokenSet.get(i).get(0).equals("}")) {
				return true;
			}
		
			
		return false;
	}
	
	private boolean S1() {
		
		if(tokenSet.get(i).get(0).equals ("ID")) {
			i++;
			
			if(tokenSet.get(i).get(0).equals ("(")) {
				i++;
				
				if(args()) {
					
					if(tokenSet.get(i).get(0).equals (")")) {
						i++;
						
						if(fun2()) {
							
							if(S_dash()) {
								
								return true;
							}
						}
					}
				}
			}
		}
		else if(tokenSet.get(i).get(0).equals ("main")) {
				i++;
				if(tokenSet.get(i).get(0).equals ("(")) {
					i++;
					
					if(tokenSet.get(i).get(0).equals (")")) {
						i++;
						
						if(tokenSet.get(i).get(0).equals ("{")) {
							i++;
							
							if(MST()) {
								
								if(tokenSet.get(i).get(0).equals ("}")) {
									i++;
									
									if(c_body()) {
										
										return true;
									}
								}
							}
						}
					}
				}
			}else if(tokenSet.get(i).get(0).equals("}")) {
				return true;
			}
		
			
		return false;
	}
	
	private boolean def() {
		
		if(tokenSet.get(i).get(0).equals ("abstract") || tokenSet.get(i).get(0).equals ("sealed") ||
				tokenSet.get(i).get(0).equals ("static") || tokenSet.get(i).get(0).equals ("class")||
				tokenSet.get(i).get(0).equals ("enum") || tokenSet.get(i).get(0).equals ("interface")) {
			
			if(def_st()) {
				if(def()) {
					return true;
				}
			}
			
		}
		else {
			
			if(tokenSet.get(i).get(0).equals ("public") || tokenSet.get(i).get(0).equals ("$")) {
				
				return true;
			}
		}
		
		return false;
	}
	
	private boolean def_st() {

		if(tokenSet.get(i).get(0).equals ("abstract") || tokenSet.get(i).get(0).equals ("sealed")||
				tokenSet.get(i).get(0).equals ("class") || tokenSet.get(i).get(0).equals ("staic") ) {
			if(abs_sea()) {
				
				if(static_dash()) {
					
					if(tokenSet.get(i).get(0).equals ("class")) {
						i++;
						if(tokenSet.get(i).get(0).equals ("ID")) {
							i++;
							
							if(inherit()) {
								
								if(tokenSet.get(i).get(0).equals ("{")) {
									i++;
									
									if(c_body()) {
										if(tokenSet.get(i).get(0).equals ("}")) {
											i++;
											return true;
										}
									}
								}
							}
						}
					}
				}
			}
		}else if(tokenSet.get(i).get(0).equals ("interface")) {
			i++;
			if(tokenSet.get(i).get(0).equals ("ID")) {
				i++;
				
				if(inherit()) {
					
					if(tokenSet.get(i).get(0).equals ("{")) {
						i++;
						
						if(int_body()) {
							
							if(tokenSet.get(i).get(0).equals ("}")) {
								i++;
								
								return true;
							}
						}
					}
				}
			}
		}
		else {
			
			if(tokenSet.get(i).get(0).equals ("enum")) {
				i++;
				if(tokenSet.get(i).get(0).equals ("ID")) {
					i++;
					
					if(inherit()) {
						
						if(tokenSet.get(i).get(0).equals ("{")) {
							i++;
							
							if(enum_body()) {
								
								if(tokenSet.get(i).get(0).equals ("}")) {
									i++;
									
									return true;
								}
							}
						}
					}
				}
			}
		}
			
	 return false;
	}
	
	private boolean Access_mod() {
		
		if(tokenSet.get(i).get(0).equals ("public")) {
			i++;
			
			return true;
		}
		else if(tokenSet.get(i).get(0).equals ("private")) {
			i++;
			
			return true;
		}
		else
			if(tokenSet.get(i).get(0).equals ("abstract") || tokenSet.get(i).get(0).equals ("sealed")||
					tokenSet.get(i).get(0).equals ("DT") || tokenSet.get(i).get(0).equals ("ID") || 
					tokenSet.get(i).get(0).equals ("String") || tokenSet.get(i).get(0).equals ("var") ||
					tokenSet.get(i).get(0).equals ("void") || tokenSet.get(i).get(0).equals ("static")||
					tokenSet.get(i).get(0).equals ("const")) {
				
				return true;
			}
		return false;
	}
	
	private boolean abs_sea() {
		
		if(tokenSet.get(i).get(0).equals ("abstract")) {
			i++;
			
			return true;
		}
		else if(tokenSet.get(i).get(0).equals ("sealed")) {
			i++;
			
			return true;
		}
		else
			if(tokenSet.get(i).get(0).equals ("static") || tokenSet.get(i).get(0).equals ("class")) {
				
				return true;
			}
		return false;
	}
	
	private boolean static_dash() {
		
		if(tokenSet.get(i).get(0).equals ("public")) {
			i++;
			
			return true;
		}
		else {
			
			if(tokenSet.get(i).get(0).equals ("class") || tokenSet.get(i).get(0).equals ("DT") ||
					tokenSet.get(i).get(0).equals ("ID") || tokenSet.get(i).get(0).equals ("String") ||
					tokenSet.get(i).get(0).equals ("var") || tokenSet.get(i).get(0).equals ("void") ||
					tokenSet.get(i).get(0).equals ("const")) {
				
				return true;
			}
		}
		return false;
	}
	
	private boolean inherit() {
		
		if(tokenSet.get(i).get(0).equals (":")) {
			i++;
			
			if(tokenSet.get(i).get(0).equals ("ID")) {
				i++;
				
				if(inherit2()) {
					
					return true;
				}
			}
		}
		else {
			
			if(tokenSet.get(i).get(0).equals ("{")) {
				
				return true;
			}
		}
		return false;
	}
	
	private boolean inherit2() {
		
		if(tokenSet.get(i).get(0).equals (",")) {
			i++;
			
			if(tokenSet.get(i).get(0).equals ("ID")) {
				i++;
				
				if(inherit2()) {
					
					return true;
				}
			}
		}
		else {
			
			if(tokenSet.get(i).get(0).equals ("{")) {
				
				return true;
			}
		}
		return false;
	}
	
	private boolean c_body() {
		if(tokenSet.get(i).get(0).equals ("public")) {
			i++;
			
			if(c_body3()) {
				
				return true;
			}
		}
		else if(tokenSet.get(i).get(0).equals ("private")) {
			i++;
			
			if(c_body3()) {
				
				return true;
			}
		}
		else if(c_body3()) {
			
			return true;
		}
		else {
			
			if(tokenSet.get(i).get(0).equals ("}")) {
				
				return true;
			}
		}
		return false;
	}
	
	private boolean c_body3() {
		
		if(tokenSet.get(i).get(0).equals ("const")) {
			i++;
			
			if(CST3()) {
				
				if(c_body()) {
					
					return true;
				}
			}
		}
		else if(tokenSet.get(i).get(0).equals ("DT")) {
			i++;
			
			if(CST4()) {
				
				if(c_body()) {
					
					return true;
				}
			}
		}
		else if(tokenSet.get(i).get(0).equals ("ID")) {
			i++;
			if(CST_doubledash()) {
				
				if(c_body()) {
					
					return true;
				}
			}
		}
		else if(tokenSet.get(i).get(0).equals ("String")) {
			i++;
			
			if(CST6()) {
				
				if(c_body()) {
					
					return true;
				}
			}
		}
		else if(tokenSet.get(i).get(0).equals ("var")) {
			i++;
			
			if(CST6()) {
				
				if(c_body()) {
					
					return true;
				}
			}
		}
		else if(tokenSet.get(i).get(0).equals ("void")) {
			i++;
			
			if(tokenSet.get(i).get(0).equals ("ID")) {
				i++;
				
				if(tokenSet.get(i).get(0).equals ("(")) {
					i++;
					
					if(args()) {
						
						if(tokenSet.get(i).get(0).equals (")")) {
							i++;
							
							if(fun2()) {
								
								if(c_body()) {
									
									return true;
								}
							}
						}
					}
				}
			}
		}
		else if(tokenSet.get(i).get(0).equals ("class")) {
			i++;
			
			if(tokenSet.get(i).get(0).equals ("ID")) {
				i++;
				
				if(inherit()) {
					
					if(tokenSet.get(i).get(0).equals ("{")) {
						i++;
						
						if(c_body()) {
							
							if(tokenSet.get(i).get(0).equals ("}")) {
								i++;
								
								if(c_body()) {
									
									return true;
								}
							}
						}
					}
				}
			}
		}
		else if(tokenSet.get(i).get(0).equals ("interface")) {
			i++;
			
			if(tokenSet.get(i).get(0).equals ("ID")) {
				i++;
				
				if(inherit()) {
					
					if(tokenSet.get(i).get(0).equals ("{")) {
						i++;
						
						if(int_body()) {
							
							if(tokenSet.get(i).get(0).equals ("}")) {
								i++;
								
								if(c_body()) {
									
									return true;
								}
							}
						}
					}
				}
			}
		}
		else if(tokenSet.get(i).get(0).equals ("enum")) {
			i++;
			if(tokenSet.get(i).get(0).equals ("ID")) {
				i++;
				
				if(inherit()) {
					
					if(tokenSet.get(i).get(0).equals ("{")) {
						i++;
						
						if(enum_body()) {
							
							if(tokenSet.get(i).get(0).equals ("}")) {
								i++;
								
								if(c_body()) {
									
									return true;
								}
							}
						}
					}
				}
			}
		}
		
		else if(tokenSet.get(i).get(0).equals ("static")) {
			i++;
			
			if(c_body1()) {
				
				return true;
			}
		}
		else if(tokenSet.get(i).get(0).equals ("abstract")) {
			i++;
			
			if(c_body2()) {
				
				return true;
			}
		}
		else if(tokenSet.get(i).get(0).equals ("sealed")) {
			i++;
			
			if(c_body2()) {
				
				return true;
			}
		}
		return false;
	}
	
	private boolean c_body1() {
		
		if(tokenSet.get(i).get(0).equals ("const") || tokenSet.get(i).get(0).equals ("DT") ||
				tokenSet.get(i).get(0).equals ("ID") || tokenSet.get(i).get(0).equals ("String") ||
				tokenSet.get(i).get(0).equals ("var") || tokenSet.get(i).get(0).equals ("void")) {
			
			if(CST2()) {
				
				if(c_body()) {
					
					return true;
				}
			}
		}
		else {
			
			if(tokenSet.get(i).get(0).equals ("class")) {
				i++;
				
				if(tokenSet.get(i).get(0).equals ("ID")) {
					i++;
					
					if(inherit()) {
						
						if(tokenSet.get(i).get(0).equals ("{")) {
							i++;
							
							if(c_body()) {
								
								if(tokenSet.get(i).get(0).equals ("}")) {
									i++;
									
									if(c_body()) {
										
										return true;
									}
								}
							}
						}
					}
				}
			}
		}
		
		return false;
	}
	
	private boolean c_body2() {
		
		if(tokenSet.get(i).get(0).equals ("DT") || tokenSet.get(i).get(0).equals ("ID") ||
				tokenSet.get(i).get(0).equals ("String") || tokenSet.get(i).get(0).equals ("var") ||
				tokenSet.get(i).get(0).equals ("void")) {
			
			if(return_type()) {
				
				if(tokenSet.get(i).get(0).equals ("ID")) {
					i++;
					
					if(tokenSet.get(i).get(0).equals ("(")) {
						i++;
						
						if(args()) {
							
							if(tokenSet.get(i).get(0).equals (")")) {
								i++;
								
								if(fun2()) {
									
									if(c_body()) {
										
										return true;
									}
								}
							}
						}
					}
				}
			}
		}
		else if(tokenSet.get(i).get(0).equals ("class")) {
				i++;
			
			if(tokenSet.get(i).get(0).equals ("ID")) {
				i++;
				
				if(inherit()) {
					
					if(tokenSet.get(i).get(0).equals ("{")) {
						i++;
						
						if(c_body()) {
							
							if(tokenSet.get(i).get(0).equals ("}")) {
								i++;
								
								if(c_body()) {
									
									return true;
								}
							}
						}
					}
				}
			}
		}
		else {
			
			if(tokenSet.get(i).get(0).equals ("static")) {
				i++;
				
				if(c_body_dash()) {
					
					return true;
				}
			}
		}
		return false;
	}
	
	private boolean c_body_dash() {
		
		if(tokenSet.get(i).get(0).equals ("DT") || tokenSet.get(i).get(0).equals ("ID") ||
				tokenSet.get(i).get(0).equals ("String") || tokenSet.get(i).get(0).equals ("var") ||
				tokenSet.get(i).get(0).equals ("void")) {
			
			if(return_type()) {
				
				if(tokenSet.get(i).get(0).equals ("ID")) {
					i++;
					
					if(tokenSet.get(i).get(0).equals ("(")) {
						i++;
						
						if(args()) {
							
							if(tokenSet.get(i).get(0).equals (")")) {
								i++;
								
								if(fun2()) {
									
									if(c_body()) {
										
										return true;
									}
								}
							}
						}
					}
				}
			}
		}
		else {
			
			if(tokenSet.get(i).get(0).equals ("class")) {
				i++;
				
				if(tokenSet.get(i).get(0).equals ("ID")) {
					i++;
					
					if(inherit()) {
						
						if(tokenSet.get(i).get(0).equals ("{")) {
							i++;
							
							if(c_body()) {
								
								if(tokenSet.get(i).get(0).equals ("}")) {
									i++;
									
									if(c_body()) {
										
										return true;
									}
								}
							}
						}
					}
				}
			}
		}
		return false;
	}
	private boolean CST_doubledash() {
		
		if(tokenSet.get(i).get(0).equals ("ID") || tokenSet.get(i).get(0).equals ("[")) {
			
			if(CST5()) {
				
				return true;
			}
		}
		else {
			
			if(tokenSet.get(i).get(0).equals ("(")) {
				i++;
				
				if(args()) {
					
					if(tokenSet.get(i).get(0).equals (")")) {
						i++;
						
						if(tokenSet.get(i).get(0).equals ("{")) {
							i++;
							
							if(MST()) {
								
								if(tokenSet.get(i).get(0).equals ("}")) {
									i++;
									
									return true;
								}
							}
						}
					}
				}
			}
		}
		return false;
	}
	
	private boolean CST2() {
		
		if(tokenSet.get(i).get(0).equals ("const")) {
			i++;
			
			if(CST3()) {
				
				return true;
			}
		}
		else if(tokenSet.get(i).get(0).equals ("DT")) {
			i++;
			
			if(CST4()) {
				
				return true;
			}
		}
		else if(tokenSet.get(i).get(0).equals ("ID")) {
			i++;
			
			if(CST5()) {
				
				return true;
			}
		}
		else if(tokenSet.get(i).get(0).equals ("String")) {
			i++;
			
			if(CST6()) {
				
				return true;
			}
		}
		else if(tokenSet.get(i).get(0).equals ("var")) {
			i++;
			
			if(CST6()) {
				
				return true;
			}
		}
		else {
			
			if(tokenSet.get(i).get(0).equals ("void")) {
				i++;
				
				if(tokenSet.get(i).get(0).equals ("ID")) {
					i++;
					
					if(tokenSet.get(i).get(0).equals ("(")) {
						i++;
						
						if(args()) {
							
							if(tokenSet.get(i).get(0).equals (")")) {
								i++;
								
								if(fun2()) {
									
									return true;
								}
							}
						}
					}
				}
			}
		}
		return false;
	}
	
	private boolean CST3() {
		
		if(tokenSet.get(i).get(0).equals ("DT")) {
			i++;
			
			if(tokenSet.get(i).get(0).equals ("ID")) {
				i++;
				
				if(init()) {
					
					if(list()) {
						
						return true;
					}
				}
			}
		}
		else {
			
			if(tokenSet.get(i).get(0).equals ("ID")) {
				i++;
				
				if(tokenSet.get(i).get(0).equals ("ID")) {
					i++;
					
					if(init2()) {
						
						if(obj2()) {
							
							return true;
						}
					}
				}
			}
		}
		return false;
	}
	
	private boolean CST4() {
		
		if(tokenSet.get(i).get(0).equals ("ID")) { //previouly DT was here
			i++;
			
			if(CST4_dash()) {
				
				return true;
			}
		}
		else {
			
			if(tokenSet.get(i).get(0).equals ("[")) {
				i++;
				
				if(tokenSet.get(i).get(0).equals ("]")) {
					i++;
					
					if(arr_O()) {
						
						if(tokenSet.get(i).get(0).equals ("ID")) {
							i++;
							
							if(tokenSet.get(i).get(0).equals ("(")) {
								i++;
								
								if(args()) {
									
									if(tokenSet.get(i).get(0).equals (")")) {
										i++;
										
										if(fun2()) {
											
											return true;
										}
									}
								}
							}
						}
					}
				}
			}
		}
		
		return false;
	}
	
	private boolean CST4_dash() {
		
		if(tokenSet.get(i).get(0).equals ("=") || tokenSet.get(i).get(0).equals (";") ||
				tokenSet.get(i).get(0).equals (",") || tokenSet.get(i).get(0).equals ("[")) {
			
			if(CST7()) {
				
				return true;
			}
		}
		else {
			
			if(tokenSet.get(i).get(0).equals ("(")) {
				i++;
				
				if(args()) {
					
					if(tokenSet.get(i).get(0).equals (")")) {
						i++;
						
						if(fun2()) {
							
							return true;
						}
					}
				}
			}
		}
		return false;
	}
	
	private boolean CST5() {
		
		if(tokenSet.get(i).get(0).equals ("ID")) { // update DT-ID
			i++;
			
			if(CST5_dash()) {
				
				return true;
			}
		}
		else {
			
			if(tokenSet.get(i).get(0).equals ("[")) {
				i++;
				
				if(tokenSet.get(i).get(0).equals ("]")) {
					i++;
					
					if(arr_O()) {
						
						if(tokenSet.get(i).get(0).equals ("ID")) {
							i++;
							
							if(tokenSet.get(i).get(0).equals ("(")) {
								i++;
								
								if(args()) {
									
									if(tokenSet.get(i).get(0).equals (")")) {
										i++;
										
										if(fun2()) {
											
											return true;
										}
									}
								}
							}
						}
					}
				}
			}
		}
		
		return false;
	}
	
	private boolean CST5_dash() {
		
		if(tokenSet.get(i).get(0).equals ("=") || tokenSet.get(i).get(0).equals ("ID") ||
				tokenSet.get(i).get(0).equals ("[")) {
			
			if(CST8()) {
				
				return true;
			}
		}
		else {
			
			if(tokenSet.get(i).get(0).equals ("(")) {
				i++;
				
				if(args()) {
					
					if(tokenSet.get(i).get(0).equals (")")) {
						i++;
						
						if(fun2()) {
							
							return true;
						}
					}
				}
			}
		}
		return false;
	}
	
	private boolean CST6() {
		
		if(tokenSet.get(i).get(0).equals ("DT")) {
			i++;
			
			if(CST6_dash()) {
				
				return true;
			}
		}
		else {
			
			if(tokenSet.get(i).get(0).equals ("[")) {
				i++;
				
				if(tokenSet.get(i).get(0).equals ("]")) {
					i++;
					
					if(arr_O()) {
						
						if(tokenSet.get(i).get(0).equals ("ID")) {
							i++;
							
							if(tokenSet.get(i).get(0).equals ("(")) {
								i++;
								
								if(args()) {
									
									if(tokenSet.get(i).get(0).equals (")")) {
										i++;
										
										if(fun2()) {
											
											return true;
										}
									}
								}
							}
						}
					}
				}
			}
		}
		
		return false;
	}
	
	private boolean CST6_dash() {
		
		if(tokenSet.get(i).get(0).equals ("[")) {
			i++;
			
			if(tokenSet.get(i).get(0).equals ("]")) {
				i++;
				
				if(arr_dec_dash()) {
					
					return true;
				}
			}
		}
		else {
			
			if(tokenSet.get(i).get(0).equals ("(")) {
				i++;
				
				if(args()) {
					
					if(tokenSet.get(i).get(0).equals (")")) {
						i++;
						
						if(fun2()) {
							
							return true;
						}
					}
				}
			}
		}
		return false;
	}
	
	private boolean CST7() {
		
		if(tokenSet.get(i).get(0).equals ("=") || tokenSet.get(i).get(0).equals (",") ||
				tokenSet.get(i).get(0).equals (";")) {
			
			if(init()) {
				
				if(list()) {
					
					return true;
				}
			}
		}
		else {
			
			if(tokenSet.get(i).get(0).equals ("[")) {
				i++;
				
				if(tokenSet.get(i).get(0).equals ("]")) {
					i++;
					
					if(arr_dec_dash()) {
						
						return true;
					}
				}
			}
		}
		return false;
	}
	
	private boolean CST8() {
		
		if(tokenSet.get(i).get(0).equals ("=") || tokenSet.get(i).get(0).equals ("ID")) {
			
			if(init2()) {
				
				if(obj2()) {
					
					return true;
				}
			}
		}
		else {
			
			if(tokenSet.get(i).get(0).equals ("[")) {
				i++;
				
				if(tokenSet.get(i).get(0).equals ("]")) {
					i++;
					
					if(arr_dec_dash()) {
						
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	private boolean fun2() {
		
		if(tokenSet.get(i).get(0).equals ("{")) {
			i++;
			
			if(MST()) {
				System.out.println("done2");
				if(tokenSet.get(i).get(0).equals ("}")) {
					i++;
					System.out.println("done3");
					return true;
				}
			}
		}
		else if(tokenSet.get(i).get(0).equals(";")){
			i++;
			return true;
//			
//			if(tokenSet.get(i).get(0).equals ("(")) {
//				i++;
//				
//				if(params()) {
//					
//					
//					if(tokenSet.get(i).get(0).equals (")")) {
//						i++;
//						
//						if(tokenSet.get(i).get(0).equals (";")) {
//							i++;
//							
//							return true;
//						}
//					}
//				}
//			}
		}
		return false;
	}
	
	private boolean return_type() {
		
		if(tokenSet.get(i).get(0).equals ("DT") || tokenSet.get(i).get(0).equals ("ID") || 
				tokenSet.get(i).get(0).equals ("String") || tokenSet.get(i).get(0).equals ("var")) {
			
			if(Data_type()) {
				
				if(arr()) {
					
					return true;
				}
			}
		}
		else {
			
			if(tokenSet.get(i).get(0).equals ("void")) {
				i++;
			
				return true;
			}
		}
		return false;
	}
	
	private boolean arr() {
		
		if(tokenSet.get(i).get(0).equals ("[")) {
			i++;
			
			if(tokenSet.get(i).get(0).equals ("]")) {
				i++;
				
				if(arr_O()) {
					
					return true;
				}
			}
		}
		else {
			
			if(tokenSet.get(i).get(0).equals ("ID")) {
				
				return true;
			}
		}
		return false;
	}
	
	private boolean arr_O() {
		
		if(tokenSet.get(i).get(0).equals ("[")) {
			i++;
			
			if(tokenSet.get(i).get(0).equals ("]")) {
				i++;
				
				return true;
			}
		}
		else {
			
			if(tokenSet.get(i).get(0).equals ("ID")) {
				
				return true;
			}
		}
		return false;
	}
	
	private boolean Data_type() {
		
		if(tokenSet.get(i).get(0).equals ("ID") || tokenSet.get(i).get(0).equals ("DT") ||
				tokenSet.get(i).get(0).equals ("String") || tokenSet.get(i).get(0).equals ("var")) {
			
			i++;
			
			return true;
		}
		return false;
	}
	
	private boolean args() {
		
		if(tokenSet.get(i).get(0).equals ("ID") || tokenSet.get(i).get(0).equals ("DT") ||
				tokenSet.get(i).get(0).equals ("String") || tokenSet.get(i).get(0).equals ("var")) {
			
			if(args_type()) {
				
				if(tokenSet.get(i).get(0).equals ("ID")) {
					i++;
					
					if(args2()) {
						
						return true;
					}
				}
			}
		}
		else {
			
			if(tokenSet.get(i).get(0).equals (")")) {
				
				return true;
			}
		}
		
		return false;
	}
	
	private boolean args2() {
		
		if(tokenSet.get(i).get(0).equals (",")) {
			i++;
			
			if(args_type()) {
				
				if(tokenSet.get(i).get(0).equals ("ID")) {
					i++;
					
					if(args2()) {
						
						return true;
					}
				}
			}
		}
		else {
			
			if(tokenSet.get(i).get(0).equals (")")) {
				
				return true;
			}
		}
		return false;
	}
	
	private boolean args_type() {
		
		if(tokenSet.get(i).get(0).equals ("ID") || tokenSet.get(i).get(0).equals ("DT") ||
				tokenSet.get(i).get(0).equals ("String") || tokenSet.get(i).get(0).equals ("var")) {
			
			if(Data_type()) {
				
				if(arr()) {
					
					return true;
				}
			}
		}
		return false;
	}
	
	private boolean int_body() {
		
		if(tokenSet.get(i).get(0).equals ("public") || tokenSet.get(i).get(0).equals ("private") ||
			tokenSet.get(i).get(0).equals ("static") || tokenSet.get(i).get(0).equals ("DT") || 
			tokenSet.get(i).get(0).equals ("ID") || tokenSet.get(i).get(0).equals ("String") ||
			tokenSet.get(i).get(0).equals ("var") || tokenSet.get(i).get(0).equals ("const") ||
			tokenSet.get(i).get(0).equals ("void") ) {
			
			if(IST()) {
				
				if(int_body()) {
					
					return true;
				}
			}
		}
		else {
			
			if(tokenSet.get(i).get(0).equals ("}")) {
				
				return true;
			}
		}
		return false;
	}
	
	private boolean IST() {
		
		if(tokenSet.get(i).get(0).equals ("public")) {
			i++;
			
			if(IST_dash()) {
				
				return true;
			}
		}
		else if(tokenSet.get(i).get(0).equals ("private")) {
			i++;
			
			if(IST_dash()) {
				
				return true;
			}
		}
		else if(tokenSet.get(i).get(0).equals ("static")) {
			i++;
			
			if(IST_doubledash()) {
				
				return true;
			}
		}
		else if(tokenSet.get(i).get(0).equals ("DT")) {
			i++;
			
			if(IST2()) {
				
				return true;
			}
		}
		else if(tokenSet.get(i).get(0).equals ("ID")) {
			i++;
			
			if(IST3()) {
				
				return true;
			}
		}
		else if(tokenSet.get(i).get(0).equals ("String")) {
			i++;
			
			if(IST4()) {
				
				return true;
			}
		}
		else if(tokenSet.get(i).get(0).equals ("var")) {
			i++;
			
			if(IST4()) {
				
				return true;
			}
		}
		else if(tokenSet.get(i).get(0).equals ("const")) {
			i++;
			
			if(IST1()) {
				
				return true;
			}
		}
		else if(tokenSet.get(i).get(0).equals ("void")) {
			i++;
			
			if(tokenSet.get(i).get(0).equals ("ID")) {
				i++;
				
				if(tokenSet.get(i).get(0).equals ("(")) {
					i++;
					
					if(args()) {
						
						if(tokenSet.get(i).get(0).equals (")")) {
							i++;
							
							if(tokenSet.get(i).get(0).equals (";")) {
								i++;
								
								return true;
							}
						}
					}
				}
			}
		}
		return false;
	}
	
	private boolean IST_dash() {
		
		if(tokenSet.get(i).get(0).equals ("ID")) {
			i++;
			
			if(IST_doubledash()) {
				
				return true;
			}
		}
		else {
			
			if(tokenSet.get(i).get(0).equals ("const") || tokenSet.get(i).get(0).equals ("DT") ||
					tokenSet.get(i).get(0).equals ("ID") || tokenSet.get(i).get(0).equals ("String") ||
					tokenSet.get(i).get(0).equals ("var")) {
				
				if(IST_doubledash()) {
					
					return true;
				}
			}
		}
		return false;
	}
	
	private boolean IST_doubledash() {
		
		if(tokenSet.get(i).get(0).equals ("const")) {
			i++;
			
			if(IST1()) {
				
				return true;
			}
		}
		else if(tokenSet.get(i).get(0).equals ("DT")) {
			i++;
			
			if(tokenSet.get(i).get(0).equals ("ID")) {
				i++;
				
				if(IST5()) {
					
					return true;
				}
			}
		}
		else if(tokenSet.get(i).get(0).equals ("ID")) {
			i++;
			
			if(tokenSet.get(i).get(0).equals ("ID")) {
				i++;
				
				if(IST6()) {
					
					return true;
				}
			}
		}
		else if(tokenSet.get(i).get(0).equals ("String")) {
			i++;
			
			if(tokenSet.get(i).get(0).equals ("ID")) {
				i++;
				
				if(tokenSet.get(i).get(0).equals ("[")) {
					i++;
					
					if(tokenSet.get(i).get(0).equals ("]")) {
						i++;
						
						if(arr_dec_dash()) {
							
							return true;
						}
					}
				}
			}
		}
		else if(tokenSet.get(i).get(0).equals ("var")) {
			i++;
			
			if(tokenSet.get(i).get(0).equals ("ID")) {
				i++;
				
				if(tokenSet.get(i).get(0).equals ("[")) {
					i++;
					
					if(tokenSet.get(i).get(0).equals ("]")) {
						i++;
						
						if(arr_dec_dash()) {
							
							return true;
						}
					}
				}
			}
		}
		
		return false;
	}
	
	private boolean IST1() {
		
		if(tokenSet.get(i).get(0).equals ("DT")) {
			i++;
			
			if(tokenSet.get(i).get(0).equals ("ID")) {
				i++;
				
				if(init()) {
					
					if(list()) {
						
						return true;
					}
				}
			}
		}
		else if(tokenSet.get(i).get(0).equals ("ID")) {
			i++;
			
			if(tokenSet.get(i).get(0).equals ("ID")) {
				i++;
				
				if(init2()) {
					
					if(obj2()) {
						
						return true;
					}
				}
			}
		}
		return false;
	}
	
	private boolean IST2() {
		
		if(tokenSet.get(i).get(0).equals ("[")) {
			i++;
			
			if(tokenSet.get(i).get(0).equals ("]")) {
				i++;
				
				if(arr_O()) {
					
					if(tokenSet.get(i).get(0).equals ("ID")) {
						i++;
						
						if(tokenSet.get(i).get(0).equals ("(")) {
							i++;
							
							if(args()) {
								
								if(tokenSet.get(i).get(0).equals (")")) {
									i++;
									
									if(tokenSet.get(i).get(0).equals (";")) {
										i++;
										
										return true;
									}
								}
							}
						}
					}
				}
			}
		}
		else {
			
			if(tokenSet.get(i).get(0).equals ("ID")) {
				i++;
				
				if(IST2_dash()) {
					
					return true;
				}
			}
		}
		return false;
	}
	
	private boolean IST2_dash() {
		
		if(tokenSet.get(i).get(0).equals ("(")) {
			i++;
			
			if(args()) {
				
				if(tokenSet.get(i).get(0).equals (")")) {
					i++;
					
					if(tokenSet.get(i).get(0).equals (";")) {
						i++;
						
						return true;
					}
				}
			}
			
		}
		else {
			
			if(tokenSet.get(i).get(0).equals ("=") || tokenSet.get(i).get(0).equals (";") ||
					tokenSet.get(i).get(0).equals (",") || tokenSet.get(i).get(0).equals ("[")) {
				
				if(IST5()) {
					
					return true;
				}
			}
		}
		return false;
	}
	
	private boolean IST3() {
		
		if(tokenSet.get(i).get(0).equals ("[")) {
			i++;
			
			if(tokenSet.get(i).get(0).equals ("]")) {
				i++;
				
				if(arr_O()) {
					
					if(tokenSet.get(i).get(0).equals ("ID")) {
						i++;
						
						if(tokenSet.get(i).get(0).equals ("(")) {
							i++;
							
							if(args()) {
								
								if(tokenSet.get(i).get(0).equals (")")) {
									i++;
									
									if(tokenSet.get(i).get(0).equals (";")) {
										i++;
										
										return true;
									}
								}
							}
						}
					}
				}
			}
		}
		else {
			
			if(tokenSet.get(i).get(0).equals ("ID")) {
				i++;
				
				if(IST3_dash()) {
					
					return true;
				}
			}
		}
		
		return false;
	}
	
	private boolean IST3_dash() {
		
		if(tokenSet.get(i).get(0).equals ("(")) {
			i++;
			
			if(args()) {
				
				if(tokenSet.get(i).get(0).equals (")")) {
					i++;
					
					if(tokenSet.get(i).get(0).equals (";")) {
						i++;
						
						return true;
					}
				}
			}
			
		}
		else {
			
			if(tokenSet.get(i).get(0).equals ("=") || tokenSet.get(i).get(0).equals ("ID") 
					|| tokenSet.get(i).get(0).equals ("[")) {
				
				if(IST6()) {
					
					return true;
				}
			}
		}
		return false;
	}
	
	private boolean IST4() {
		
		if(tokenSet.get(i).get(0).equals ("[")) {
			i++;
			
			if(tokenSet.get(i).get(0).equals ("]")) {
				i++;
				
				if(arr_O()) {
					
					if(tokenSet.get(i).get(0).equals ("ID")) {
						i++;
						
						if(tokenSet.get(i).get(0).equals ("(")) {
							i++;
							
							if(args()) {
								
								if(tokenSet.get(i).get(0).equals (")")) {
									i++;
									
									if(tokenSet.get(i).get(0).equals (";")) {
										i++;
										
										return true;
									}
								}
							}
						}
					}
				}
			}
		}
		else {
			
			if(tokenSet.get(i).get(0).equals ("ID")) {
				i++;
				
				if(IST4_dash()) {
					
					return true;
				}
			}
		}
		
		return false;
	}
	
	private boolean IST4_dash() {
		
		if(tokenSet.get(i).get(0).equals ("(")) {
			i++;
			
			if(args()) {
				
				if(tokenSet.get(i).get(0).equals (")")) {
					i++;
					
					if(tokenSet.get(i).get(0).equals (";")) {
						i++;
						
						return true;
					}
				}
			}
			
		}
		else {
			
			if(tokenSet.get(i).get(0).equals ("[")) {
				i++;
				
				if(tokenSet.get(i).get(0).equals ("]")) {
					i++;
					
					if(arr_dec_dash()) {
						
						return true;
					}
				}
			}
		}
		return false;
	}
	
	private boolean IST5() {
		
		if(tokenSet.get(i).get(0).equals ("=") || tokenSet.get(i).get(0).equals (";") ||
				tokenSet.get(i).get(0).equals (",")) {
			
			if(init()) {
				
				if(list()) {
					
					return true;
				}
			}
		}
		else {
			
			if(tokenSet.get(i).get(0).equals ("[")) {
				i++;
				
				if(tokenSet.get(i).get(0).equals ("]")) {
					i++;
					
					if(arr_dec_dash()) {
						
						return true;
					}
				}
			}
		}
		return false;
	}
	
	private boolean IST6() {
		
		if(tokenSet.get(i).get(0).equals ("=") || tokenSet.get(i).get(0).equals ("ID")) {
			
			if(init2()) {
				
				if(obj2()) {
					
					return true;
				}
			}
		}
		else {
			
			if(tokenSet.get(i).get(0).equals ("[")) {
				i++;
				
				if(tokenSet.get(i).get(0).equals ("]")) {
					i++;
					
					if(arr_dec_dash()) {
						
						return true;
					}
				}
			}
		}
		return false;
	}
	
	private boolean enum_body() {
		if(tokenSet.get(i).get(0).equals ("ID") || tokenSet.get(i).get(0).equals ("public") ||
				tokenSet.get(i).get(0).equals ("private") || tokenSet.get(i).get(0).equals ("static") ||
				tokenSet.get(i).get(0).equals ("const") || tokenSet.get(i).get(0).equals ("DT") ||
				tokenSet.get(i).get(0).equals ("abstract") || tokenSet.get(i).get(0).equals ("sealed") ||
				tokenSet.get(i).get(0).equals ("String") || tokenSet.get(i).get(0).equals ("var") ||
				tokenSet.get(i).get(0).equals ("void")) {
			if(EST()) {
				
				if(enum_body()) {
					
					return true;
				}
			}
		}
		else {
			
			if(tokenSet.get(i).get(0).equals ("}")) {
				
				return true;
			}
		}
		return false;
	}
	
	private boolean EST() {
		if(tokenSet.get(i).get(0).equals ("ID")) {
			i++;
			
			if(EST_dash()) {
				
				return true;
			}
		}
		else if(tokenSet.get(i).get(0).equals ("public")) {
			i++;
			
			if(EST_doubledash()) {
				
				return true;
			}
		}
		else if(tokenSet.get(i).get(0).equals ("private")) {
			i++;
			
			if(EST_doubledash()) {
				
				return true;
			}
		}
		else if(tokenSet.get(i).get(0).equals ("static")) {
			i++;
			
			if(EST1()) {
				
				return true;
			}
		}
		else if(tokenSet.get(i).get(0).equals ("const")) {
			i++;
			
			if(EST3()) {
				
				return true;
			}
		}
		else if(tokenSet.get(i).get(0).equals ("DT")) {
			i++;
			
			if(EST2()) {
				
				return true;
			}
		}
		else if(tokenSet.get(i).get(0).equals ("abstract")) {
			
			if(static_dash()) {
				
				if(return_type()) {
					
					if(tokenSet.get(i).get(0).equals ("ID")) {
						i++;
						
						if(tokenSet.get(i).get(0).equals ("(")) {
							i++;
							
							if(args()) {
								
								if(tokenSet.get(i).get(0).equals (")")) {
									i++;
									
									if(fun2()) {
										
										return true;
									}
								}
							}
						}
					}
				}
			}
		}
		else if(tokenSet.get(i).get(0).equals ("sealed")) {
			
			if(static_dash()) {
				
				if(return_type()) {
					
					if(tokenSet.get(i).get(0).equals ("ID")) {
						i++;
						
						if(tokenSet.get(i).get(0).equals ("(")) {
							i++;
							
							if(args()) {
								
								if(tokenSet.get(i).get(0).equals (")")) {
									i++;
									
									if(fun2()) {
										
										return true;
									}
								}
							}
						}
					}
				}
			}
		}
		else if(tokenSet.get(i).get(0).equals ("String")) {
			i++;
			
			if(EST4()) {
				
				return true;
			}
		}
		else if(tokenSet.get(i).get(0).equals ("var")) {
			i++;
			
			if(EST4()) {
				
				return true;
			}
		}
		else if(tokenSet.get(i).get(0).equals ("void")) {
			i++;
			
			if(tokenSet.get(i).get(0).equals ("ID")) {
				i++;
				
				if(tokenSet.get(i).get(0).equals ("(")) {
					i++;
					
					if(args()) {
						
						if(tokenSet.get(i).get(0).equals (")")) {
							i++;
							
							if(fun2()) {
								
								return true;
							}
						}
					}
				}
			}
		}
		return false;
	}
	
	private boolean EST_dash() {
		
		if(tokenSet.get(i).get(0).equals ("=") || tokenSet.get(i).get(0).equals (",") ||
				tokenSet.get(i).get(0).equals ("ID") || tokenSet.get(i).get(0).equals ("public") ||
				tokenSet.get(i).get(0).equals ("private") || tokenSet.get(i).get(0).equals ("static") ||
				tokenSet.get(i).get(0).equals ("const") || tokenSet.get(i).get(0).equals ("DT") ||
				tokenSet.get(i).get(0).equals ("abstract") || tokenSet.get(i).get(0).equals ("sealed") ||
				tokenSet.get(i).get(0).equals ("String") || tokenSet.get(i).get(0).equals ("var") ||
				tokenSet.get(i).get(0).equals ("void")) {
			if(ev()) {
				
				if(ev2()) {
					
					return true;
				}
			}
			
		}else if(tokenSet.get(i).get(0).equals ("ID")) {
			i++;
			
			if(EST_dash1()) {
				
				return true;
			}
		}
		else if(tokenSet.get(i).get(0).equals ("(")) {
			i++;
			
			if(args()) {
				
				if(tokenSet.get(i).get(0).equals (")")) {
					i++;
					
					if(tokenSet.get(i).get(0).equals ("{")) {
						i++;
						
						if(MST()) {
							
							if(tokenSet.get(i).get(0).equals ("}")) {
								i++;
								
								return true;
							}
						}
					}
				}
			}
		}
		else if(tokenSet.get(i).get(0).equals ("[")) {
			i++;
			
			if(tokenSet.get(i).get(0).equals ("]")) {
				i++;
				
				if(arr_O()) {
					
					if(tokenSet.get(i).get(0).equals ("ID")) {
						i++;
						
						if(tokenSet.get(i).get(0).equals ("(")) {
							i++;
							
							if(args()) {
								
								if(tokenSet.get(i).get(0).equals (")")) {
									i++;
									
									if(fun2()) {
										
										return true;
									}
								}
							}
						}
					}
				}
			}
		}
		return false;
	}
	
	private boolean EST_dash1() {
		
		if(tokenSet.get(i).get(0).equals ("[")) {
			i++;
			
			if(tokenSet.get(i).get(0).equals ("]")) {
				i++;
				
				if(arr_dec_dash()) {
					
					return true;
				}
			}
		}
		else if(tokenSet.get(i).get(0).equals ("=") || tokenSet.get(i).get(0).equals ("ID")) {
			
			if(init2()) {
				
				if(obj2()) {
					
					return true;
				}
			}
		}
		else if(tokenSet.get(i).get(0).equals ("(")) {
			i++;
			
			if(args()) {
				
				if(tokenSet.get(i).get(0).equals (")")) {
					i++;
					
					if(fun2()) {
						
						return true;
					}
				}
			}
			
		}
		return false;
	}
	
	private boolean EST_doubledash() {
		
		if(tokenSet.get(i).get(0).equals ("static")) {
			i++;
			
			if(EST1()) {
				
				return true;
			}
		}
		else if(tokenSet.get(i).get(0).equals ("const")) {
			i++;
			
			if(EST3()) {
				
				return true;
			}
		}
		else if(tokenSet.get(i).get(0).equals ("DT")) {
			i++;
			
			if(EST2()) {
				
				return true;
			}
		}
		else if(tokenSet.get(i).get(0).equals ("ID")) {
			i++;
			
			if(EST_doubledash1()) {
				
				return true;
			}
		}
		else if(tokenSet.get(i).get(0).equals ("abstract")) {
			
			if(static_dash()) {
				
				if(return_type()) {
					
					if(tokenSet.get(i).get(0).equals ("ID")) {
						i++;
						
						if(tokenSet.get(i).get(0).equals ("(")) {
							i++;
							
							if(args()) {
								
								if(tokenSet.get(i).get(0).equals (")")) {
									i++;
									
									if(fun2()) {
										
										return true;
									}
								}
							}
						}
					}
				}
			}
		}
		else if(tokenSet.get(i).get(0).equals ("sealed")) {
			
			if(static_dash()) {
				
				if(return_type()) {
					
					if(tokenSet.get(i).get(0).equals ("ID")) {
						i++;
						
						if(tokenSet.get(i).get(0).equals ("(")) {
							i++;
							
							if(args()) {
								
								if(tokenSet.get(i).get(0).equals (")")) {
									i++;
									
									if(fun2()) {
										
										return true;
									}
								}
							}
						}
					}
				}
			}
		}
		else if(tokenSet.get(i).get(0).equals ("String")) {
			i++;
			
			if(EST4()) {
				
				return true;
			}
		}
		else if(tokenSet.get(i).get(0).equals ("var")) {
			i++;
			
			if(EST4()) {
				
				return true;
			}
		}
		else if(tokenSet.get(i).get(0).equals ("void")) {
			i++;
			
			if(tokenSet.get(i).get(0).equals ("ID")) {
				i++;
				
				if(tokenSet.get(i).get(0).equals ("(")) {
					i++;
					
					if(args()) {
						
						if(tokenSet.get(i).get(0).equals (")")) {
							i++;
							
							if(fun2()) {
								
								return true;
							}
						}
					}
				}
			}
		}
		return false;
	}
	
	private boolean EST_doubledash1() {
		
		if(tokenSet.get(i).get(0).equals ("[") || tokenSet.get(i).get(0).equals ("ID")) {
			
			if(EST13()) {
				
				return true;
			}
		}
		else if(tokenSet.get(i).get(0).equals ("(")) {
			i++;
			
			if(args()) {
				
				if(tokenSet.get(i).get(0).equals (")")) {
					i++;
					
					if(tokenSet.get(i).get(0).equals ("{")) {
						i++;
						
						if(MST()) {
							
							if(tokenSet.get(i).get(0).equals ("}")) {
								i++;
								
								return true;
							}
						}
					}
				}
			}
		}
		return false;
	}
	
	private boolean EST1() {
		
		if(tokenSet.get(i).get(0).equals ("const")) {
			i++;
			
			if(EST3()) {
				
				return true;
			}
		}
		else if(tokenSet.get(i).get(0).equals ("DT")) {
			i++;
			
			if(EST2()) {
				
				return true;
			}
		}
		else if(tokenSet.get(i).get(0).equals ("ID")) {
			i++;
			
			if(EST13()) {
				
				return true;
			}
		}
		else if(tokenSet.get(i).get(0).equals ("String")) {
			i++;
			
			if(EST4()) {
				
				return true;
			}
		}
		else if(tokenSet.get(i).get(0).equals ("var")) {
			i++;
			
			if(EST4()) {
				
				return true;
			}
		}
		else if(tokenSet.get(i).get(0).equals ("void")) {
			i++;
			
			if(tokenSet.get(i).get(0).equals ("ID")) {
				i++;
				
				if(tokenSet.get(i).get(0).equals ("(")) {
					i++;
					
					if(args()) {
						
						if(tokenSet.get(i).get(0).equals (")")) {
							i++;
							
							if(fun2()) {
								
								return true;
							}
						}
					}
				}
			}
		}
		return false;
	}	
	
	private boolean EST13() {
		
		if(tokenSet.get(i).get(0).equals ("[")) {
			i++;
			
			if(tokenSet.get(i).get(0).equals ("]")) {
				i++;
				
				if(arr_O()) {
					
					if(tokenSet.get(i).get(0).equals ("ID")) {
						i++;
						
						if(tokenSet.get(i).get(0).equals ("(")) {
							i++;
							
							if(args()) {
								
								if(tokenSet.get(i).get(0).equals (")")) {
									i++;
									
									if(fun2()) {
										
										return true;
									}
								}
							}
						}
					}
				}
			}
		}
		else {
			
			if(tokenSet.get(i).get(0).equals ("ID")) {
				i++;
				
				if(EST_dash1()) {
					
					return true;
				}
			}
		}
		
		return false;
	}
	
	private boolean EST2() {
		
		if(tokenSet.get(i).get(0).equals ("[")) {
			i++;
			
			if(tokenSet.get(i).get(0).equals ("]")) {
				i++;
				
				if(arr_O()) {
					
					if(tokenSet.get(i).get(0).equals ("ID")) {
						i++;
						
						if(tokenSet.get(i).get(0).equals ("(")) {
							i++;
							
							if(args()) {
								
								if(tokenSet.get(i).get(0).equals (")")) {
									i++;
									
									if(fun2()) {
										
										return true;
									}
								}
							}
						}
					}
				}
			}
		}
		else {
			
			if(tokenSet.get(i).get(0).equals ("ID")) {
				i++;
				
				if(EST2_dash()) {
					
					return true;
				}
			}
		}
		
		return false;
	}
	
	private boolean EST2_dash() {
		
		
		if(tokenSet.get(i).get(0).equals ("=") || tokenSet.get(i).get(0).equals (";") ||
				tokenSet.get(i).get(0).equals (",")) {
			
			if(init()) {
				
				if(list()) {
					
					return true;
				}
			}
		}
		else if(tokenSet.get(i).get(0).equals ("(")) {
			i++;
			
			if(args()) {
				
				if(tokenSet.get(i).get(0).equals (")")) {
					i++;
					
					if(fun2()) {
						
						return true;
					}
				}
			}
		}
		else if(tokenSet.get(i).get(0).equals ("[")) {
			i++;
			
			if(tokenSet.get(i).get(0).equals ("]")) {
				i++;
				
				if(arr_dec_dash()) {
					
					return true;
				}
			}
		}
		
		return false;
	}
	
	private boolean EST3() {
		
		if(tokenSet.get(i).get(0).equals ("DT")) {
			i++;
			
			if(tokenSet.get(i).get(0).equals ("ID")) {
				i++;
				
				if(init()) {
					
					if(list()) {
						
						return true;
					}
				}
			}
		}
		else if(tokenSet.get(i).get(0).equals ("ID")) {
			i++;
			
			if(tokenSet.get(i).get(0).equals ("ID")) {
				i++;
				
				if(init2()) {
					
					if(obj2()) {
						
						return true;
					}
				}
			}
		}
		return false;
	}
	
	private boolean EST4() {
		
		if(tokenSet.get(i).get(0).equals ("[")) {
			i++;
			
			if(tokenSet.get(i).get(0).equals ("]")) {
				i++;
				
				if(arr_O()) {
					
					if(tokenSet.get(i).get(0).equals ("ID")) {
						i++;
						
						if(tokenSet.get(i).get(0).equals ("(")) {
							i++;
							
							if(args()) {
								
								if(tokenSet.get(i).get(0).equals (")")) {
									i++;
									
									if(fun2()) {
										
										return true;
									}
								}
							}
						}
					}
				}
			}
		}
		else {
			
			if(tokenSet.get(i).get(0).equals ("ID")) {
				i++;
				
				if(EST4_dash()) {
					
					return true;
				}
			}
		}
		
		return false;
	}
	
	private boolean EST4_dash() {

		if(tokenSet.get(i).get(0).equals ("(")) {
			i++;
			
			if(args()) {
				
				if(tokenSet.get(i).get(0).equals (")")) {
					i++;
					
					if(fun2()) {
						
						return true;
					}
				}
			}
		}
		else if(tokenSet.get(i).get(0).equals ("[")) {
			i++;
			
			if(tokenSet.get(i).get(0).equals ("]")) {
				i++;
				
				if(arr_dec_dash()) {
					
					return true;
				}
			}
		}
			
		return false;
	}
	
	private boolean ev2() {
		
		if(tokenSet.get(i).get(0).equals (",")) {
			i++;
			
			if(tokenSet.get(i).get(0).equals ("ID")) {
				i++;
				
				if(ev()) {
					
					if(ev2()) {
						
						return true;
					}
				}
			}
		}
		else {
			
			if(tokenSet.get(i).get(0).equals ("ID") || tokenSet.get(i).get(0).equals ("public")||
					tokenSet.get(i).get(0).equals ("private") || tokenSet.get(i).get(0).equals ("static") ||
					tokenSet.get(i).get(0).equals ("const") || tokenSet.get(i).get(0).equals ("DT")|| 
					tokenSet.get(i).get(0).equals ("abstract") || tokenSet.get(i).get(0).equals ("sealed") ||
					tokenSet.get(i).get(0).equals ("String") || tokenSet.get(i).get(0).equals ("var") ||
					tokenSet.get(i).get(0).equals ("void")) {
				
				return true;
			}
		}
		return false;
	}
	
	private boolean ev() {
		
		if(tokenSet.get(i).get(0).equals ("=")) {
			i++;
			
			if(tokenSet.get(i).get(0).equals ("int_const")) {
				i++;
				
				return true;
			}
		}
		else {
			
			if(tokenSet.get(i).get(0).equals ("ID") || tokenSet.get(i).get(0).equals ("public")||
					tokenSet.get(i).get(0).equals ("private") || tokenSet.get(i).get(0).equals ("static") ||
					tokenSet.get(i).get(0).equals ("const") || tokenSet.get(i).get(0).equals ("DT")|| 
					tokenSet.get(i).get(0).equals ("abstract") || tokenSet.get(i).get(0).equals ("sealed") ||
					tokenSet.get(i).get(0).equals ("String") || tokenSet.get(i).get(0).equals ("var") ||
					tokenSet.get(i).get(0).equals ("void") || tokenSet.get(i).get(0).equals (",")) {
				return true;
			}
		}
		return false;
	}
	
	private boolean case_st() {
		
		if(tokenSet.get(i).get(0).equals ("case")) {
			i++;
			
			if(constants()) {
				
				if(tokenSet.get(i).get(0).equals (":")) {
					i++;
					
					if(case_body()) {
						
						if(tokenSet.get(i).get(0).equals ("break")) {
							i++;
							
							if(tokenSet.get(i).get(0).equals (":")) {
								i++;
								
								if(case_st()) {
									
									return true;
								}
							}
						}
					}
				}
			}
		}
		else if(tokenSet.get(i).get(0).equals ("default")) {
			i++;
			
			if(tokenSet.get(i).get(0).equals (":")) {
				i++;
				
				if(MST()) {
					
					return true;
				}
			}
		}
		else {
			
			if(tokenSet.get(i).get(0).equals ("}")) {
				
				return true;
			}
		}
		return false;
	}
	
	private boolean case_body() {
		
		if(tokenSet.get(i).get(0).equals ("const")) {
			i++;
			
			if(case_dash()) {
				
				return true;
			}
		}
		else if(tokenSet.get(i).get(0).equals ("DT")) {
			i++;
			
			if(tokenSet.get(i).get(0).equals ("ID")) {
				i++;
				
				if(case_doubledash()) {
					
					return true;
				}
			}
			
		}
		else if(tokenSet.get(i).get(0).equals ("while")) {
			
			if(while_stmt()) {
				
				return true;
			}
		}
		else if(tokenSet.get(i).get(0).equals ("for")) {
			
			if(for_stmt()) {
				
				return true;
			}
		}
		else if(tokenSet.get(i).get(0).equals ("if")) {
			
			if(if_elif_stmt()) {
				
				return true;
			}
		}
		else if(tokenSet.get(i).get(0).equals ("do")) {
			
			if(dowhile_stmt()) {
				
				return true;
			}
		}
		else if(tokenSet.get(i).get(0).equals ("forEach")) {
			
			if(forEach()) {
				
				return true;
			}
		}
		else if(tokenSet.get(i).get(0).equals ("switch")) {
			
			if(switch_stmt()) {
				
				return true;
			}
		}
		else if(tokenSet.get(i).get(0).equals ("this")) {
			i++;
			
			if(tb2()) {
				
				if(tokenSet.get(i).get(0).equals("ID")) {
					i++;
					
					if(case1()) {
						
						return true;
					}
				}
			
			}
		}
		else if(tokenSet.get(i).get(0).equals ("base")) {
			i++;
			
			if(tb2()) {
				
				if(tokenSet.get(i).get(0).equals("ID")) {
					i++;
					
					if(case1()) {
						
						return true;
					}
				}
			
			}
		}
		else if(tokenSet.get(i).get(0).equals ("inc_dec")) {
			i++;
			
			if(X()) {
				
				if(tokenSet.get(i).get(0).equals(";")) {
					i++;
					
					return true;
				}
			}
		}
		else if(tokenSet.get(i).get(0).equals ("ID")) {
			i++;
			
			if(case2()) {
				
				return true;
			}
		}
		else if(tokenSet.get(i).get(0).equals ("String")) {
			i++;
			
			if(tokenSet.get(i).get(0).equals ("ID")) {
				i++;
				
				if(tokenSet.get(i).get(0).equals ("[")) {
					i++;
					
					if(tokenSet.get(i).get(0).equals ("]")) {
						i++;
						
						if(arr_dec_dash()) {
							
							return true;
						}
					}
				}
			}
		}
		else if(tokenSet.get(i).get(0).equals ("var")) {
			i++;
			
			if(tokenSet.get(i).get(0).equals ("ID")) {
				i++;
				
				if(tokenSet.get(i).get(0).equals ("[")) {
					i++;
					
					if(tokenSet.get(i).get(0).equals ("]")) {
						i++;
						
						if(arr_dec_dash()) {
							
							return true;
						}
					}
				}
			}
		}
		
		return false;
	}
	
	private boolean case_dash() {
		
		if(tokenSet.get(i).get(0).equals ("DT")) {
			i++;
			
			if(tokenSet.get(i).get(0).equals ("ID")) {
				i++;
				
				if(init()) {
					
					if(list()) {
						
						return true;
					}
				}
			}
		}
		else if(tokenSet.get(i).get(0).equals ("ID")) {
			i++;
			
			if(tokenSet.get(i).get(0).equals ("ID")) {
				i++;
				
				if(init2()) {
					
					if(obj2()) {
						
						return true;
					}
				}
			}
		}
		return false;
	}
	
	private boolean case_doubledash() {
		
		if(tokenSet.get(i).get(0).equals ("=") || tokenSet.get(i).get(0).equals (";") ||
				tokenSet.get(i).get(0).equals (",")) {
			
			if(init()) {
				
				if(list()) {
					
					return true;
				}
			}
		}
		else if(tokenSet.get(i).get(0).equals ("[")) {
			i++;
			
			if(tokenSet.get(i).get(0).equals ("]")) {
				i++;
				
				if(arr_dec_dash()) {
					
					return true;
				}
			}
		}
		
		return false;
	}
	
	private boolean case1() {
		
		if(tokenSet.get(i).get(0).equals (".")) {
			i++;
			
			if(tokenSet.get(i).get(0).equals ("ID")) {
				i++;
				
				if(case1()) {
					
					return true;
				}
			}
		}
		else if(tokenSet.get(i).get(0).equals ("=") || tokenSet.get(i).get(0).equals ("CAO") || 
				tokenSet.get(i).get(0).equals ("inc_dec")) {
			
			if(case1_dash()) {
				
				return true;
			}
		}
		else if(tokenSet.get(i).get(0).equals ("[")) {
			i++;
			
			if(OE()) {
				
				if(tokenSet.get(i).get(0).equals ("]")) {
					i++;
					
					if(arr2()) {
						
						if(case12()) {
							
							return true;
						}
					}
				}
			}
		}
		else if(tokenSet.get(i).get(0).equals ("(")) {
			i++;
			
			if(params()) {
				
				if(tokenSet.get(i).get(0).equals (")")) {
					i++;
					
					if(case13()) {
						
						return true;
					}
				}
			}
		}
		return false;
	}
	
	private boolean case1_dash() {
		
		if(tokenSet.get(i).get(0).equals ("=") || tokenSet.get(i).get(0).equals ("CAO")) {
			
			if(ass_opr()) {
				
				if(OE()) {
					
					if(tokenSet.get(i).get(0).equals (";")) {
						i++;
						
						return true;
					}
				}
			}
		}
		else if(tokenSet.get(i).get(0).equals ("inc-dec")) {
			i++;
			
			if(tokenSet.get(i).get(0).equals (";")) {
				i++;
				
				return true;
			}
		}
		
		return false;
	}
	
	private boolean case12() {
		
		if(tokenSet.get(i).get(0).equals (".")) {
			i++;
			
			if(tokenSet.get(i).get(0).equals ("ID")) {
				i++;
				
				if(case1()) {
					
					return true;
				}
			}
		}
		else if(tokenSet.get(i).get(0).equals ("=") || tokenSet.get(i).get(0).equals ("CAO") || 
				tokenSet.get(i).get(0).equals ("inc_dec")) {
			
			if(case1_dash()) {
				
				return true;
			}
		}
		return false;
	}
	
	private boolean case13() {
		
		if(tokenSet.get(i).get(0).equals (".")) {
			i++;
			
			if(tokenSet.get(i).get(0).equals ("ID")) {
				i++;
				
				if(case1()) {
					
					return true;
				}
			}
		}
		else if(tokenSet.get(i).get(0).equals ("[")) {
			i++;
			
			if(OE()) {
				
				if(tokenSet.get(i).get(0).equals ("]")) {
					i++;
					
					if(arr2()) {
						
						if(case12()) {
							
							return true;
						}
					}
				}
			}
		}
		else {
			
			if(tokenSet.get(i).get(0).equals(";")) {
				i++;
				
				return true;
			}
		}
		return false;
	}
	
	private boolean case2() {
		
		if(tokenSet.get(i).get(0).equals(",") || tokenSet.get(i).get(0).equals("=") ||
				tokenSet.get(i).get(0).equals("CAO") || tokenSet.get(i).get(0).equals("inc_dec") ||
				tokenSet.get(i).get(0).equals("[") || tokenSet.get(i).get(0).equals("(")) {
			
			if(case1()) {
				
				return true;
			}
		}
		else if(tokenSet.get(i).get(0).equals("ID")) {
			
			i++;
			
			if(case_doubledash()) {
				
				return true;
			}
		}
		return false;
	}
	
	private boolean MST() {
		
//		{ const, DT, while, for, if, do, forEach, 
//			switch, ID, this, base, inc_dec, return, pass, break, try, String, var, throw }
	
		
		if(tokenSet.get(i).get(0).equals("const") || tokenSet.get(i).get(0).equals("DT") || tokenSet.get(i).get(0).equals("while")||
			tokenSet.get(i).get(0).equals("for") || tokenSet.get(i).get(0).equals("if") || tokenSet.get(i).get(0).equals("do") ||
			tokenSet.get(i).get(0).equals("forEach") || tokenSet.get(i).get(0).equals("switch") || tokenSet.get(i).get(0).equals("ID") ||
			tokenSet.get(i).get(0).equals("this") || tokenSet.get(i).get(0).equals("base") || tokenSet.get(i).get(0).equals("inc_dec")||
			tokenSet.get(i).get(0).equals("return") || tokenSet.get(i).get(0).equals("pass") || tokenSet.get(i).get(0).equals("break") ||
			tokenSet.get(i).get(0).equals("try") || tokenSet.get(i).get(0).equals("String") || tokenSet.get(i).get(0).equals("var") ||
			tokenSet.get(i).get(0).equals("throw")) {
			
			if(SST()) {
				if(MST()) {
					return true;
				}
			}
			
		}else if(tokenSet.get(i).get(0).equals("}")) {
			return true;
		}
		
		return false;
	}
	
	private boolean SST() {
		if(tokenSet.get(i).get(0).equals("const")) {
			i++;
			if(SST_dash()) {
				return true;
			}
		}else if(tokenSet.get(i).get(0).equals("DT")) {
			i++;
			
			if(tokenSet.get(i).get(0).equals("ID")) {
				i++;
		
				if(SST1()) {
					return true;
				}
			}
		}else if (while_stmt() || for_stmt() || if_elif_stmt() || dowhile_stmt() || forEach() || switch_stmt()
				|| return_stmt() || try_catch_stmt() || throw_stmt()) {
		
			return true;
		
		}else if(tokenSet.get(i).get(0).equals("ID")) {
			i++;
			
			if(SST2()) {
				return true;
			}
			
		}else if(tokenSet.get(i).get(0).equals("this") || tokenSet.get(i).get(0).equals("base")) {
			
			i++;
			
			if(tb2()) {
				if(tokenSet.get(i).get(0).equals("ID")) {
					
					i++;
					
					if(SST3()) {
						return true;
					}
				}
			}
			
		}else if(tokenSet.get(i).get(0).equals("inc_dec")) {
			i++;
			
			if(X()) {
				if(tokenSet.get(i).get(0).equals(";")){
					i++;
					
					return true;
				}
			}
		
		}else if(tokenSet.get(i).get(0).equals("pass") || tokenSet.get(i).get(0).equals("break")){
			
			i++;
			
			if(tokenSet.get(i).get(0).equals(";")) {
				i++;
				return true;
			}
		}else if(tokenSet.get(i).get(0).equals("String") || tokenSet.get(i).get(0).equals("var")) {
			i++;
			
			if(tokenSet.get(i).get(0).equals("ID")) {
				i++;
				
				if(tokenSet.get(i).get(0).equals("[")) {
					i++;
					if(tokenSet.get(i).get(0).equals("]")) {
						i++;
						
						if(arr_dec_dash()) {
							return true;
						}
					}
				}
			}
				
			
		}
		
		return false;
	}
	
	private boolean SST_dash() {
		
		if(tokenSet.get(i).get(0).equals("DT")) {
			i++;
			if(tokenSet.get(i).get(0).equals("ID")) {
				
				i++;
				if(init()) {
					if(list()) {
						return true;
					}
				}
			}
		}else if (tokenSet.get(i).get(0).equals("ID")) {
			i++;
			if(tokenSet.get(i).get(0).equals("ID")) {
				
				i++;
				if(init2()) {
					if(obj2()) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	private boolean SST1() {
		
		if(init()){
			if(list()) {
				return true;
			}
		}else if(tokenSet.get(i).get(0).equals("[")){
			i++;
			if(tokenSet.get(i).get(0).equals("]")) {
				i++;
				if(arr_dec_dash()) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	private boolean SST2() {
		
		
		if(SST3()) {
			return true;
		}else if(tokenSet.get(i).get(0).equals("ID")) {
			i++;
			
			if(SST_double_dash()) {
				return true;
			}
		}
		
		return false;
	}
	
	private boolean SST_double_dash() {
		
		if(init2()) {
			if(obj2()) {
				return true;
			}
		}else if(tokenSet.get(i).get(0).equals("[")) {
			i++;
			
			if(tokenSet.get(i).get(0).equals("]")) {
				i++;
				if(arr_dec_dash()) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	
	private boolean SST3() {
		
		if(tokenSet.get(i).get(0).equals(".")) {
			i++;
			
			if(tokenSet.get(i).get(0).equals("ID")) {
				i++;
				
				if(SST3()) {
					return true;
				}
			}
		}else if(SST3_dash()) {
			return true;
		
		}else if(tokenSet.get(i).get(0).equals("[")) {
			i++;
			
			if(OE()) {
				if(tokenSet.get(i).get(0).equals("]")) {
					i++;
					
					if(arr2()) {
							if(SST32()) {
								return true;
							}
					}
				}
			}
		}else if (tokenSet.get(i).get(0).equals("(")) {
			i++;
		
			if(params()) {
				if(tokenSet.get(i).get(0).equals(")")) {
					i++;
			
					if(SST33()) {
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	private boolean SST3_dash() {
		
		if(ass_opr()) {
			if(OE()) {
				if(tokenSet.get(i).get(0).equals(";")) {
					i++;
				return true;
				}
			}
		}else if (tokenSet.get(i).get(0).equals("inc_dec")) {
			i++;
			
			if(tokenSet.get(i).get(0).equals(";")) {
				i++;
				return true;
			}
			
			return true;
		
		}
		
		
		return false;
	}
	
	private boolean SST32() {
		
		if(tokenSet.get(i).get(0).equals(".")) {
			i++;
			
			if(tokenSet.get(i).get(0).equals("ID")) {
				i++;
				
				if(SST3()) {
					return true;
				}
			}
		}else if(SST3_dash()) {
			return true;
		}
		
		return false;
	}
	
	private boolean SST33() {
	
		if(tokenSet.get(i).get(0).equals(".")) {
			i++;
			
			if(tokenSet.get(i).get(0).equals("ID")) {
				i++;
				
				if(SST3()) {
					return true;
				}
			}
		}else if (tokenSet.get(i).get(0).equals("[")) {
			i++;
			if(OE()) {
				
				if(tokenSet.get(i).get(0).equals("]")) {
					i++;
					
					if(arr2()) {
						if(SST32()) {
							return true;
						}
					}
				}
			}
			
		}else if (tokenSet.get(i).get(0).equals(";")) {
			i++;
			return true;
		}
		
		
		return false;
	}
	
	private boolean body() {
		
		if(tokenSet.get(i).get(0).equals(";")) {
			i++; 
			
			return true;
		}else if(SST()) {
			return true;
		}else if (tokenSet.get(i).get(0).equals("{")) {
			i++;
			if(MST()) {
				if(tokenSet.get(i).get(0).equals("}")) {
					i++;
					return true;
				}
			}
			
		}
		
		return false;
	}
	
	private boolean while_stmt() {
	
		if(tokenSet.get(i).get(0).equals("while")) {
			i++;
			
			if(tokenSet.get(i).get(0).equals("(")) {
				i++;
				if(OE()) {
					
					if(tokenSet.get(i).get(0).equals(")")) {
						i++;
					
						if(body()) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}
	
	private boolean for_stmt() {
		
		
		if(tokenSet.get(i).get(0).equals("for")) {
			i++;
			
			if(tokenSet.get(i).get(0).equals("(")) {
				i++;
				if(c1()) {
					
					if(c2()) {
								
						if(tokenSet.get(i).get(0).equals(";")) {
							i++;
									
							if(c3()) {
								
								if(tokenSet.get(i).get(0).equals(")")) {
									i++;
									if(body()) {
										return true;
									}
								}
								
								
							}
						}
					}
				}
			}
		}
		return false;
	}
	
	private boolean if_elif_stmt() {
		
		if(tokenSet.get(i).get(0).equals("if")) {
			i++;
			if(tokenSet.get(i).get(0).equals("(")) {
				i++;
				if(OE()) {
					if(tokenSet.get(i).get(0).equals(")")) {
						i++;
						if(body()) {
							if(elif()) {
								if(else_dash()) {
									return true;
								}
							}
						}
					}
				}
			}
		}
		
		return false;
	}
	
	private boolean dowhile_stmt() {
		
		if(tokenSet.get(i).get(0).equals("do")) {
			i++;
			
			if(body()) {
				
				if(tokenSet.get(i).get(0).equals("while")) {
					i++;
					
					if(tokenSet.get(i).get(0).equals("(")) {
						
						i++;
						
						if(OE()) {
							
							if(tokenSet.get(i).get(0).equals(")")) {
								i++;
								
								if(tokenSet.get(i).get(0).equals(";")) {
									i++;
									
									return true;
								}
							}
						}
					}
				}
			}
		}
		
		return false;
	}
	
	private boolean forEach() {
		
		if(tokenSet.get(i).get(0).equals("forEach")) {
			i++;
			
			if(tokenSet.get(i).get(0).equals("(")) {
				i++;
				
				if(Data_type()) {
					
					if(tokenSet.get(i).get(0).equals("ID")) {
						
						i++;
						
						if(tokenSet.get(i).get(0).equals("in")) {
							i++;
							
							if(tokenSet.get(i).get(0).equals("ID")) {
								i++;
								
								if(tokenSet.get(i).get(0).equals(")")) {
									i++;
									
									if(body()) {
										return true;
									}
								}
							}
						}
					}
				}
			}
		}
		
		return false;
	}
	
	private boolean switch_stmt() {
		
		if(tokenSet.get(i).get(0).equals("switch")) {
			i++;
			
			if(tokenSet.get(i).get(0).equals("(")) {
				i++;
				
				
				if(constants()) {
					if(tokenSet.get(i).get(0).equals(")")) {
						i++;
						if(tokenSet.get(i).get(0).equals("{")) {
							i++;
							
							if(case_st()) {
								if(tokenSet.get(i).get(0).equals("}")) {
									i++;
									return true;
								}
							}
						}
					}
				}
			}
		}
		
		return false;
	}
	
	private boolean return_stmt() {
		
		
		if(tokenSet.get(i).get(0).equals("return")) {
			i++;
			
			if(RST()) {
				return true;
			}
		}
		return false;
	}
	
	private boolean try_catch_stmt() {
		
		if(tokenSet.get(i).get(0).equals("try")) {
			i++;
			
			if(tokenSet.get(i).get(0).equals("{")) {
				i++;
				
				if(MST()) {
					
					if(tokenSet.get(i).get(0).equals("}")) {
						i++;
						
						if(tokenSet.get(i).get(0).equals("catch")) {
							i++;
							
							if(tokenSet.get(i).get(0).equals("(")) {
								i++;
								
								if(tokenSet.get(i).get(0).equals("ID")) { // for Exception
									
									i++;
									
									if(tokenSet.get(i).get(0).equals(")")) {
										i++;
										
										if(tokenSet.get(i).get(0).equals("{")) {
											i++;
											
											if(MST()) {
												
												if(tokenSet.get(i).get(0).equals("}")) {
													i++;
													return true;
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		
		return false;
	}
	
	private boolean throw_stmt() {
		
		if(tokenSet.get(i).get(0).equals("throw")) {
			i++;
			
			if(tokenSet.get(i).get(0).equals("new")) {
				i++;
				
				if(tokenSet.get(i).get(0).equals("ID")) {
					
					i++;
					
					if(tokenSet.get(i).get(0).equals("(")) {
						i++;
						
						if(params()) {
							
							if(tokenSet.get(i).get(0).equals(")")) {
								i++;
								
								if(tokenSet.get(i).get(0).equals(";")) {
									i++;
									
									return true;
								}
							}
						}
					}
				}
			}
		}
		
		return false;
	}
	
	// assignment
	
	private boolean assignment() {
		
		if(X()) {
			if(ass_opr()) {
				if(OE()) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	// ass_opr
	private boolean ass_opr() {
		
		if(tokenSet.get(i).get(0).equals("=") || tokenSet.get(i).get(0).equals("CAO")) {
			i++;
			
			return true;
		}
		return false;
	}
	
	
	// init2 
	
	private boolean init2() {
		if(tokenSet.get(i).get(0).equals("=")) {
			i++;
			
			if(tokenSet.get(i).get(0).equals("new")) {
				i++;
				
				if(tokenSet.get(i).get(0).equals("ID")) {
					i++;
					
					if(Y()) {
						if(tokenSet.get(i).get(0).equals(";")) {
							i++;
							return true;
						}
					}
				}
			}
		}
		return false;
	}
	
	// obj2
	
	private boolean obj2() {
	
		if(tokenSet.get(i).get(0).equals(",")) {
			i++;
			
			if(tokenSet.get(i).get(0).equals("ID")) {
				i++;
				
				if(init2()) {
					if(obj2()) {
						return true;
					}
				}
			}
		}else if (tokenSet.get(i).get(0).equals(";")) {
			return true;
			
//			{ public, private, const, DT, ID, String, var, void, class, interface, enum, static, abstract, 
//				sealed, while, for, if, do, forEach, switch, this, base, inc_dec, return, pass, break, try, throw, elif, else, } }

		}else if(tokenSet.get(i).get(0).equals("public") || tokenSet.get(i).get(0).equals("private") || tokenSet.get(i).get(0).equals("const")||
				tokenSet.get(i).get(0).equals("DT") || tokenSet.get(i).get(0).equals("ID") || tokenSet.get(i).get(0).equals("String") ||
				tokenSet.get(i).get(0).equals("var") || tokenSet.get(i).get(0).equals("void") || tokenSet.get(i).get(0).equals("class") ||
				tokenSet.get(i).get(0).equals("interface") || tokenSet.get(i).get(0).equals("enum") || tokenSet.get(i).get(0).equals("static")||
				tokenSet.get(i).get(0).equals("abstract") || tokenSet.get(i).get(0).equals("sealed") || tokenSet.get(i).get(0).equals("while")||
				tokenSet.get(i).get(0).equals("for") || tokenSet.get(i).get(0).equals("if") || tokenSet.get(i).get(0).equals("do") ||
				tokenSet.get(i).get(0).equals("forEach") || tokenSet.get(i).get(0).equals("switch") || tokenSet.get(i).get(0).equals("this") ||
				tokenSet.get(i).get(0).equals("base") || tokenSet.get(i).get(0).equals("inc_dec") || tokenSet.get(i).get(0).equals("return") ||
				tokenSet.get(i).get(0).equals("pass") || tokenSet.get(i).get(0).equals("break") || tokenSet.get(i).get(0).equals("try") ||
				tokenSet.get(i).get(0).equals("throw") || tokenSet.get(i).get(0).equals("elif") || tokenSet.get(i).get(0).equals("else") ||
				tokenSet.get(i).get(0).equals("}")
				) {
			
				return true;
		}
		return false;
	}
	
	
	private boolean c1() {

		if(tokenSet.get(i).get(0).equals(";")) {
			i++;
			return true;
		}else if (dec()) {
			return true;
		}else if (assignment()) {
			if(tokenSet.get(i).get(0).equals(";")) {
				i++;
				return true;
			}
		}
		return false;
	}
	
	private boolean c2() {
		
		if(OE()) {
			return true;
			
		
		// null
		}else if(tokenSet.get(i).get(0).equals(";")) {
			return true;
		}
		return false;
	}
	
	// c3
	
	private boolean c3() {
		if(X()) {
			if(c3_dash()) {
				return true;
			}
		}else if (tokenSet.get(i).get(0).equals("inc_dec")) {
			i++;
			
			if(X()) {
				return true;
			}
			
			// null
		}else if(tokenSet.get(i).get(0).equals(")")){
			return true;
		}
		
		return false;
	}
	
	// c3'
	
	private boolean c3_dash() {
		if(ass_opr()) {
			if(OE()) {
				return true;
			}
		}else if(tokenSet.get(i).get(0).equals("inc_dec")){
			i++;
			return true;
		}
		
		return false;
	}
	
	// elif
	
	private boolean elif() {
		
		if(tokenSet.get(i).get(0).equals("elif")) {
			i++;
			
			if(tokenSet.get(i).get(0).equals("(")) {
				i++;
				
				if(OE()) {
					
					if(tokenSet.get(i).get(0).equals(")")) {
						i++;
						
						if(body()) {
							if(elif()) {
								return true;
							}
						}
					}
				}
			}
		//const, DT, while, for, if, do, forEach, switch, ID, this, base, inc_dec,
//			return, pass, break, try, String, var, throw, elif, else, }
		
		}else if (tokenSet.get(i).get(0).equals("else")) {
			return true;
		}
		
		return false;
	}
	
	
	// else_dash
	
	private boolean else_dash() {
		
		if(tokenSet.get(i).get(0).equals("else")) {
			i++;
			
			if(body()) {
				return true;
			}
		
		}
		
		return false;
	}
	
	private boolean arr_dec_dash() {
		if(tokenSet.get(i).get(0).equals("[")) {
			i++;
			if(tokenSet.get(i).get(0).equals("]")) {
				i++;
				if(val()) {
					if(tokenSet.get(i).get(0).equals(";")) {
						i++;
						return true;
					}
				}
			}
		}else if (val()) {
			//System.out.println("from val "+tokenSet.get(i).get(0));
			if(tokenSet.get(i).get(0).equals(";")) {
				i++;
				return true;
				
			}
		}
		
		return false;
	}
	
	// val implementation
	
	
	private boolean val() {
		
		if(tokenSet.get(i).get(0).equals("=")) {
			i++;
			if(val_dash()) {
				return true;
			}
		}else if(tokenSet.get(i).get(0).equals(";")) {
			return true;
		}
		
		
		return false;
	}
	
	// val' implementation
	
	private boolean	val_dash() {
	
		if(tokenSet.get(i).get(0).equals("{")) {
			i++;
			
			if(v1()) {
				return true;
			}
		}
		return false;
	}
	
	// v1,v2 ,v3, val_1D impelmentation
	
	private boolean v1() {
		
		if(val_1D()) {
			if(tokenSet.get(i).get(0).equals("}")) {
				i++;
				return true;
				
			}
			
		}else if(tokenSet.get(i).get(0).equals("{")) {
			i++;
			
			if(val_1D()) {
				if(tokenSet.get(i).get(0).equals("}")) {
					i++;
					
					if(v3()) {
						if(tokenSet.get(i).get(0).equals("}")) {
							i++;
							
							return true;
						}
					}
				}
			}
		}
		
		return false;
	}
		
	private boolean v2() {
		
		
		if(tokenSet.get(i).get(0).equals(",")) {
			i++;
			if(val_1D()) {
				return true;
			}
		}else if(tokenSet.get(i).get(0).equals("}")) {
			return true;
		}
		return false;
	}
	
	private boolean v3() {
		if(tokenSet.get(i).get(0).equals(",")) {
			i++;
			if(tokenSet.get(i).get(0).equals("{")) {
				i++;
				if(val_1D()) {
					
					if(tokenSet.get(i).get(0).equals("}")) {
						i++;
						if(v3()) {
							return true;
						}
					}
				}	
			}
			
		}else if(tokenSet.get(i).get(0).equals("}")) {
			return true;
		}
		
		return false;
	}
	
	private boolean val_1D() {
		
		if(OE()) {
			if(v2()) {
				return true;
			}
		}else if(tokenSet.get(i).get(0).equals("new")) {
			i++;
			
			if(tokenSet.get(i).get(0).equals("ID")) {
				i++;
				
				if(tokenSet.get(i).get(0).equals("(")) {
					i++;
					
					if(params()) {
						if(tokenSet.get(i).get(0).equals(")")) {
							i++;
							
							if(v2()) {
								return true;
							}
						}
					}
				}
			}
		}
		return false;
	}
	
	
	// RST implementation
	
	private boolean RST() {
		
		if(tokenSet.get(i).get(0).equals(";")) {
			i++;
			return true;
			
		}else if(tokenSet.get(i).get(0).equals("this") || tokenSet.get(i).get(0).equals("base")){
			i++;
			if(RST_dash()) {
				return true;
			}
		}else if (tokenSet.get(i).get(0).equals("ID")) {
			i++;
			
			if(F_dash()) {
				if(exp()) {
					if(tokenSet.get(i).get(0).equals(";")) {
						i++;
						return true;
					}
				}
			}
			
		}else if (constants()) {
			if(exp()) {
				if(tokenSet.get(i).get(0).equals(";")) {
					i++;
					return true;
				}
			}
		}else if (tokenSet.get(i).get(0).equals("(")) {
			i++;
			
			if(OE()) {
				
				if(tokenSet.get(i).get(0).equals(")")) {
					i++;
					if(exp()) {
						if(tokenSet.get(i).get(0).equals(";")) {
							i++;
							return true;
						}
					}
				}
			}
		}else if (tokenSet.get(i).get(0).equals("!")) {
			i++;
			
			if(F()) {
				if(exp()) {
					
					if(tokenSet.get(i).get(0).equals(";")) {
						i++;
						return true;
					}
				}
			}
		}else if (tokenSet.get(i).get(0).equals("inc_dec")) {
			i++;
			
			if(X()) {
				if(exp()) {
					if(tokenSet.get(i).get(0).equals(";")) {
						i++;
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	// RST' and RST''
	
	private boolean RST_dash() {
		
		if(tokenSet.get(i).get(0).equals(".")) {
			i++;
			if(tokenSet.get(i).get(0).equals("ID")) {
				i++;
				
				if(F_dash()) {
					
					if(exp()) {
						if(tokenSet.get(i).get(0).equals(";")) {
							i++;
							return true;
						}
					}
				}
			}
		
		}else if(tokenSet.get(i).get(0).equals("(")) {
			i++;
			
			if(params()) {
				
				if(tokenSet.get(i).get(0).equals(")")) {
					i++;
					
					if(RST_double_dash()) {
						return true;
					}
				}
			}
		}
		return true;
	}
	
	private boolean RST_double_dash() {
		
		if(tokenSet.get(i).get(0).equals(".")) {
			i++;
			if(tokenSet.get(i).get(0).equals("ID")) {
				i++;
				
				if(F_dash()) {
					
					if(exp()) {
						if(tokenSet.get(i).get(0).equals(";")) {
							i++;
							return true;
						}
					}
				}
			}
		
		}else if(tokenSet.get(i).get(0).equals(";")) {
			i++;
			return true;
		}
		
		return false;
	}
	
	// dec implementation
	

	private boolean dec() {
		
		if(tokenSet.get(i).get(0).equals("const") || tokenSet.get(i).get(0).equals("DT")) {
			
			i++;
			if(tokenSet.get(i).get(0).equals("DT")) {
				
				i++;
				if(tokenSet.get(i).get(0).equals("ID")) {
					
					i++;
					if(init()) {
						
						if(list()) {
							return true;
						}
					}
				}
				
			}else if(tokenSet.get(i).get(0).equals("ID")) {
				i++;
				if(init()) {
					if(list()) {
						return true;
					}
				}
			}
			
		}
		
		return false;
	}
	
	private boolean init() {
	
		if(tokenSet.get(i).get(0).equals("=")) {
			
			i++;
			
			if(tokenSet.get(i).get(0).equals("int_const")) {
				i++;
				return true;
			}
			
		}else {
			
			
			if(tokenSet.get(i).get(0).equals(";") || tokenSet.get(i).get(0).equals(",")) {
				return true;
			
			}
			
			
		}
		

		return false;
	}
	
	private boolean list() {
		
//		System.out.println(tokenSet.get(i).get(0));
	
		if(tokenSet.get(i).get(0).equals(";")) {
			i++;
			return true;
			
		}else if(tokenSet.get(i).get(0).equals(",")) {
			
			i++;
			if(tokenSet.get(i).get(0).equals("ID")) {
				i++;
			
				if(init()) {
					return list();
				}
			}
		}
		
		return false;
	}

	
	// Implementation of params
	
	private boolean params() {
		
		if(tokenSet.get(i).get(0).equals("this")) {
			i++;
			if(th_dash()) {
				if(p2()) {
					
					return true;
				}
			}
		}else if (tokenSet.get(i).get(0).equals("base")) {
			i++;
			
			if(th_dash()) {
				if(p2()) {
					
					return true;
				}
			}
			
		}else if(tokenSet.get(i).get(0).equals("ID")) {
			i++;

			if(F_dash()) {
				if(exp()) {
					if(p2()) {
						
						return true;
					}
				}
			}
			
		}else if(p2()) {
			return true;
		
			
		}else if(constants()) {
			if(exp()) {
				if(p2()) {
					
					return true;
				}
			}
		}else if(tokenSet.
				
				
				get(i).get(0).equals("(")) {
			i++;
			if(OE()) {
				if(tokenSet.get(i).get(0).equals(")")) {
					i++;
					if(exp()) {
						if(p2()) {
							
							return true;
						}

					}
				}
			}
		}else if (tokenSet.get(i).get(0).equals("!")) {
			i++;
			
			if(F()) {
				if(exp()) {
					if(p2()) {
						
						return true;
					}

				}
			}
			
		}else if(tokenSet.get(i).get(0).equals("inc_dec")) {
			i++;
			
			if(X()) {
				if(exp()) {

					if(p2()) {
						
						return true;
					}

				}
			}
		}else if(tokenSet.get(i).get(0).equals(")")) {
			return true;
		}
		
			
		return false;
	}
	
	
	private boolean th_dash() {
		
		if(tokenSet.get(i).get(0).equals("(")) {
			i++;
			
			if(params()) {
				if(tokenSet.get(i).get(0).equals(")")) {
					i++;
					
					if(th_2dash()) {
						return true;
					}
				}
			}
		}else if (tokenSet.get(i).get(0).equals(".")) {
			i++;
			if(tokenSet.get(i).get(0).equals("ID")) {
				i++;
				
				if(F_dash()) {
					if(exp()) {
						return true;
					}
				}
			}
		}else if(tokenSet.get(i).get(0).equals(")") || tokenSet.get(i).get(0).equals(",")) {
			return true;
		}
		
		return false;
	}
	
	private boolean th_2dash() {
	
//		if(p2()) {
//			return true;
//		}else
		
		
		if(tokenSet.get(i).get(0).equals(".")) {
			i++;
			
			if(tokenSet.get(i).get(0).equals("ID")) {
				i++;
				
				if(F_dash()) {
					if(exp()) {
						return true;
					}
				}
			}
		}else if(tokenSet.get(i).get(0).equals(")")) {
			return true;
		}
		
		return false;
	}

	
	private boolean exp() {
	
		if(T_dash()) {
			
			if(E_dash()) {
			
				if(RE_dash()) {
			
					if(AE_dash()) {
				
						if(OE_dash()) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	
	private boolean p2() {
		
		if(tokenSet.get(i).get(0).equals(",")) {
			i++;
			if(p2_dash()) {
				if(p2()) {
					return true;
				}
			}

		}else if(tokenSet.get(i).get(0).equals(")")){
			
			return true;
		}
		
		
		return false;
	}
	
	private boolean p2_dash() {
		
		if(tokenSet.get(i).get(0).equals("this")) {
			i++;
			
			if(th_double_dash()) {
				return true;
			}
		}else if(tokenSet.get(i).get(0).equals("base")) {
			i++;
			if(th_double_dash()) {
				return true;
			}
		}else if(tokenSet.get(i).get(0).equals("ID")) {
			i++;
			if(F_dash()) {
				if(exp()) {
					return true;
				}
			}
		}else if(constants()) {
			if(exp()) {
				return true;
			}
		}else if(tokenSet.get(i).get(0).equals("(")) {
			i++;
			if(OE()) {
				
				if(tokenSet.get(i).get(0).equals(")")) {
					i++;
					if(exp()) {
						
						return true;
					}
				}
			}
		}else if(tokenSet.get(i).get(0).equals("!")) {
			i++;
			
			if(F()) {
				if(exp()) {
					return true;
				}
			}
			
		}else if(tokenSet.get(i).get(0).equals("inc_dec")) {
			i++;
			if(X()) {
				if(exp()) {
					return true;
				}
			}
		}
		
		return false;
	
	}
	
	private boolean th_double_dash() {
		
		if(tokenSet.get(i).get(0).equals("(")) {
			
			i++;
			
			if(params()) {
				if(tokenSet.get(i).get(0).equals(")")) {
					i++;
					
					if(th_2double_dash()) {
						return true;
					}
				}
			}
			
		}else if(tokenSet.get(i).get(0).equals(".")) {
			i++;
			
			if(tokenSet.get(i).get(0).equals("ID")) {
				i++;
				
				if(F_dash()) {
					if(exp()) {
						return true;
					}
				}
			}
		}
		
		
		return false;
	}
	
	private boolean th_2double_dash() {
		
		if(tokenSet.get(i).get(0).equals(".")) {
			
			i++;
			if(tokenSet.get(i).get(0).equals("ID")) {
				i++;
				
				if(F_dash()) {
					if(exp()) {
						return true;
					}
				}
			}
			
		}else if(tokenSet.get(i).get(0).equals(",") || tokenSet.get(i).get(0).equals(")")) {
			return true;
		}
		
		return false;
	}
	
	
	
	
	
	
	
	
	// Implementation of Y
	
	
	private boolean Y() {
		
		if(tokenSet.get(i).get(0).equals(".")) {
			i++;
			
			if(tokenSet.get(i).get(0).equals("ID")) {
				i++;
				
				if(Y()) {
					
					return true;
				}
			}
		}else if(tokenSet.get(i).get(0).equals("(")) {
			
			i++;
			if(params()) {
			
				if(tokenSet.get(i).get(0).equals(")")) {
					i++;
					
					if(Y1()) {
						return true;
					}
				}
			}
			
		}else if(arr_dash()) {
			
			if(tokenSet.get(i).get(0).equals(".")) {
				i++;
				
				if(tokenSet.get(i).get(0).equals("ID")) {
					i++;
					
					if(Y()) {
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	private boolean Y1() {
		
		if(tokenSet.get(i).get(0).equals(".")) {
			i++;
			
			if(tokenSet.get(i).get(0).equals("ID")) {
				i++;
				
				if(Y()) {
					return true;
				}
			}
		}else if(arr_dash()) {
			
			if(tokenSet.get(i).get(0).equals(".")) {
				i++;
				
				if(tokenSet.get(i).get(0).equals("ID")) {
					i++;
					if(Y()) {
						return true;
					}
				}
			}
		}else if(tokenSet.get(i).get(0).equals(";")) {
			return true;
		}
		
		return false;
	}
	
	private boolean arr_dash() {
	
		if(tokenSet.get(i).get(0).equals("[")) {
			i++;
			
			if(OE()) {
				
				if(tokenSet.get(i).get(0).equals("]")) {
					i++;
					
					if(arr2()) {
						return true;
					}
					
				}
		}
		}
		return false;
	}
	
	
	// OE implementation
	
	private boolean OE() {
		
		if(tokenSet.get(i).get(0).equals("this") || tokenSet.get(i).get(0).equals("base") || tokenSet.get(i).get(0).equals("ID") ||
				tokenSet.get(i).get(0).equals("int_const") 
				|| tokenSet.get(i).get(0).equals("char_constant") || tokenSet.get(i).get(0).equals("bool_const") || tokenSet.get(i).get(0).equals("string_const")
			|| tokenSet.get(i).get(0).equals("float_const") || tokenSet.get(i).get(0).equals("(") || tokenSet.get(i).get(0).equals("!")
			|| tokenSet.get(i).get(0).equals("inc_dec")
			
				) {

			if(AE()) {
				
				if(OE_dash()) {
					return true;
				}
			}
			
			
			
		}
		
		return false;
	}
	

	

	private boolean OE_dash() {
	
		

		if(tokenSet.get(i).get(0).equals("OR")) {
		
			i++;
			
			if(AE()) {
				if(OE_dash()) {
					return true;
				}
			}

		}else if(tokenSet.get(i).get(0).equals(")") || tokenSet.get(i).get(0).equals("]") || 
				tokenSet.get(i).get(0).equals(";") || tokenSet.get(i).get(0).equals(",") || tokenSet.get(i).get(0).equals("}")){
			
			
			
			return true;	
		}
		
		return false;
	}
	
	private boolean AE() {
		
		
		if(RE()) {
				if(AE_dash()) {
					
					return true;
				}
			}
			
			
		

		
		
		return false;
	}


	private boolean AE_dash() {
 
		
		if(tokenSet.get(i).get(0).equals("AND")) {
			
			i++;
			if(RE()) {
				
				if(AE_dash()) {
					return true;
				}
			}
		}else if(tokenSet.get(i).get(0).equals("OR") ||tokenSet.get(i).get(0).equals(")") || tokenSet.get(i).get(0).equals("]") || 
				tokenSet.get(i).get(0).equals(";") || tokenSet.get(i).get(0).equals(",") || tokenSet.get(i).get(0).equals("}")) {
		
			return true;
		}
		
		return false;
	}
	


	private boolean RE() {
	
		
		if(E()) {
				if(RE_dash()) {
					return true;
				}
			}
			
		
		
		return false;
	}
	
	private boolean RE_dash() {
		
		
		if(tokenSet.get(i).get(0).equals("ROP")) {
			i++;
			if(E()) {
				if(RE_dash()) {
					return true;
				}
			}
			
		}else if(tokenSet.get(i).get(0).equals("AND") || tokenSet.get(i).get(0).equals("OR") ||tokenSet.get(i).get(0).equals(")") || tokenSet.get(i).get(0).equals("]") || 
				tokenSet.get(i).get(0).equals(";") || tokenSet.get(i).get(0).equals(",") || tokenSet.get(i).get(0).equals("}")){
			
			return true;
		}
		
		return false;
	}
	

	private boolean E() {

		if(T()) {
			if(E_dash()) {
				return true;
			}
		}
		
		return false;
	}
	

	private boolean E_dash() {

	
		if(tokenSet.get(i).get(0).equals("PM")) {
			i++;
			if(T()) {
				if(E_dash()) {
					
					return true;
				}
			}
		}else if(tokenSet.get(i).get(0).equals("ROP") || tokenSet.get(i).get(0).equals("AND") || tokenSet.get(i).get(0).equals("OR") ||tokenSet.get(i).get(0).equals(")") || tokenSet.get(i).get(0).equals("]") || 
				
				tokenSet.get(i).get(0).equals(";") || tokenSet.get(i).get(0).equals(",") || tokenSet.get(i).get(0).equals("}")) {
		
			return true;
		}
		
		return false;
	}
	

	private boolean T() {

		if(F()) {
			if(T_dash()) {
				return true;
			}
		}
		
		
		return false;
	}
	

	private boolean T_dash() {
		
		if(tokenSet.get(i).get(0).equals("MDM")) {
			i++;
			if(F()) {
				if(T_dash()) {
					return true;
				}
			}
		}else if(tokenSet.get(i).get(0).equals("PM") || tokenSet.get(i).get(0).equals("ROP") || tokenSet.get(i).get(0).equals("AND") || tokenSet.get(i).get(0).equals("OR") ||tokenSet.get(i).get(0).equals(")") || tokenSet.get(i).get(0).equals("]") || 
				
				tokenSet.get(i).get(0).equals(";") || tokenSet.get(i).get(0).equals(",") || tokenSet.get(i).get(0).equals("}")) {
	
			return true;
		}
		
		return false;
	}
	

	private boolean F() {

		if(tb()) {
			if(tokenSet.get(i).get(0).equals("ID")) {
				i++;
				
				if(F_dash()) {
					return true;
				}
			}
		}else if(constants()) {
			return true;
			
		}else if(tokenSet.get(i).get(0).equals("(")) {
			i++;
			if(OE()) {
				if(tokenSet.get(i).get(0).equals(")")) {
					i++;
					return true;
					
				}
			}
		}else if(tokenSet.get(i).get(0).equals("!")) {
			i++;
			if(F()) {
				return true;
			}
		}else if(tokenSet.get(i).get(0).equals("inc_dec")){
			i++;
			if(X()) {
				return true;
			}
		}
		
		return false;
	}
	

	private boolean F_dash() {

		
		if(tokenSet.get(i).get(0).equals(".")) {
			i++;
			if(tokenSet.get(i).get(0).equals("ID")) {
				i++;
				
				if(F_dash()) {
				
					return true;
				}
			}
			
		}else if(tokenSet.get(i).get(0).equals("[")){
			i++;
			if(OE()) {
				
				if(tokenSet.get(i).get(0).equals("]")) {
					i++;
					
					if(arr2()) {
						
						if(F2()) {
							return true;
						}
					}
				}
			}
		}else if(tokenSet.get(i).get(0).equals("(")) {
			
			i++;
			
			if(params()) {
				if(tokenSet.get(i).get(0).equals(")")) {
					i++;
					if(F3()) {
						return true;
					}
				}
			}
			
		}else if(F_double_dash()) {
			return true;
		
		
		}
		
		return false;
	}
	

	private boolean F2() {
		
		if(tokenSet.get(i).get(0).equals(".")) {
			
			i++;
			if(tokenSet.get(i).get(0).equals("ID")) {
				i++;
				
				if(F_dash()) {
					return true;
				}
			}
			
		}else if(F_double_dash()) {
			
			return true;
		}
		
		return false;
	}
	

	private boolean F3() {
		
		if(tokenSet.get(i).get(0).equals(".")) {
			i++;
			
			if(tokenSet.get(i).get(0).equals("ID")) {
				
				i++;
				
				if(F_dash()) {
					return true;
				}
			}
			
		}else if(tokenSet.get(i).get(0).equals("[")) {
			
			i++;
			if(OE()) {
				
				if(tokenSet.get(i).get(0).equals("]")) {
					i++;
					
					if(arr2()) {
						
						if(F2()) {
							
							return true;
						}
					}
				}
			}
		}else if(tokenSet.get(i).get(0).equals("MDM") || tokenSet.get(i).get(0).equals("PM") || tokenSet.get(i).get(0).equals("ROP") ||
				tokenSet.get(i).get(0).equals("AND") || tokenSet.get(i).get(0).equals("OR") ||tokenSet.get(i).get(0).equals(")") || tokenSet.get(i).get(0).equals("]") || 
				tokenSet.get(i).get(0).equals(";") || tokenSet.get(i).get(0).equals(",") || tokenSet.get(i).get(0).equals("}")
			 ){
			
			return true;
			
		}
		
		
		return false;
	}
	

	private boolean F_double_dash() {
		
		

		if(tokenSet.get(i).get(0).equals("inc_dec")) {
			i++;
			
			return true;
		
			
//			{ MDM, PM, ROP, AND, OR, ), ], ;, , , } }
		
		}else if(tokenSet.get(i).get(0).equals("MDM") || tokenSet.get(i).get(0).equals("PM") || tokenSet.get(i).get(0).equals("ROP") ||
				tokenSet.get(i).get(0).equals("AND") || tokenSet.get(i).get(0).equals("OR") ||tokenSet.get(i).get(0).equals(")") || tokenSet.get(i).get(0).equals("]") || 
				tokenSet.get(i).get(0).equals(";") || tokenSet.get(i).get(0).equals(",") || tokenSet.get(i).get(0).equals("}")
			 ){

			return true;
			
		}
		
		return false;
	}
	
	
	
	private boolean constants() {
		
		if(tokenSet.get(i).get(0).equals("int_const") || tokenSet.get(i).get(0).equals("float_const") 
				|| tokenSet.get(i).get(0).equals("char_const") || tokenSet.get(i).get(0).equals("string_const")
				) {
			i++;
			return true;
		}
		return false;
	}
	
	
	// X non Terminal implementation
	
	private boolean X() {
		
		
		if(tb()) {
			
			if(tokenSet.get(i).get(0).equals("ID") ) {
				System.out.println("ID found");
				i++;
				if(x_dash()) {
					System.out.println("true");
					return true;
				}
				
			}
		}
		
		return false;
	
	}
	
	
	
	private boolean tb() {
	
		if(tokenSet.get(i).get(0).equals("this") || tokenSet.get(i).get(0).equals("base")) {
			
			i++;
			
			if(tb2()) {
				return true;
			}
			
		}else {
			if(tokenSet.get(i).get(0).equals("ID")){
				return true;
			}
		}
		
		return false;
	}
	
	
	private boolean tb2() {
		
		if(tokenSet.get(i).get(0).equals(".")) {
			i++;
			return true;
			
		}else if(tokenSet.get(i).get(0).equals("(")) {
			i++;
			if(params()) {
			
				if(tokenSet.get(i).get(0).equals(")")) {
					i++;
					if(tokenSet.get(i).get(0).equals(".")) {
						i++;
						return true;
					}
				}
			}
			
			
		}
		
		return false;
	}
	private boolean x_dash() {

		if(x_double_dash()) {
			return true;
		}else if(x1()) {
			
			if(x_double_dash()) {
				return true;
			}
		}else if(x2()){
			return true;
		}
		
		return false;
	}
	
	private boolean x_double_dash() {
		
		if(tokenSet.get(i).get(0).equals(".")) {
			i++;
		
			if(tokenSet.get(i).get(0).equals("ID")) {
				i++;
				
				if(x_dash()) {
				
					return true;
				
				}
			}
		}else {
			if(tokenSet.get(i).get(0).equals("MDM") || tokenSet.get(i).get(0).equals("PM") || 
					tokenSet.get(i).get(0).equals("ROP") || tokenSet.get(i).get(0).equals("AND") ||
					tokenSet.get(i).get(0).equals("OR") || tokenSet.get(i).get(0).equals(")") ||
					tokenSet.get(i).get(0).equals("]") || tokenSet.get(i).get(0).equals(";") || tokenSet.get(i).get(0).equals(",") ||
					tokenSet.get(i).get(0).equals("}") || tokenSet.get(i).get(0).equals("SA") ||
					tokenSet.get(i).get(0).equals("CAO") || tokenSet.get(i).get(0).equals("inc_dec")) {
				
				
				return true;
			}
		}
		
		return false;
	}
	
	private boolean x1() {
		
		if(tokenSet.get(i).get(0).equals("'[")) {
			i++;
		
			if(OE()) {
				if(tokenSet.get(i).get(0).equals("]")) {
					i++;
					
					if(arr2()) {
						return true;
					}
					
				}
			}
		}
		
		
		return false;
	}
	
	private boolean x2() {
		
		if(tokenSet.get(i).get(0).equals("(")) {
			i++;
			
			
			if(params()) {
				if(tokenSet.get(i).get(0).equals(")")) {
					i++;
					if(x_op()) {
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	private boolean x_op() {
		
		if(tokenSet.get(i).get(0).equals(".")) {
			i++;
			if(tokenSet.get(i).get(0).equals("ID")) {
				i++;
				if(x_dash()) {
				
					return true;
				
				}
			}
			
		}else {
			
			if(x_dash()) {
				if(x_double_dash()) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	
	
	private boolean arr2() {
		
		if(tokenSet.get(i).get(0).equals("[")) {
			i++;
			if(OE()) {
				if(tokenSet.get(i).get(0).equals("]")) {
					i++;
					return true;
				
				}
			}
		}else {
			
//			. , MDM, PM, ROP, AND, OR, ), ], ;, , , }, =, CAO, inc_dec
			
			if(tokenSet.get(i).get(0).equals(".") || tokenSet.get(i).get(0).equals("MDM") || tokenSet.get(i).get(0).equals("PM")||
					tokenSet.get(i).get(0).equals("ROP") || tokenSet.get(i).get(0).equals("AND") || tokenSet.get(i).get(0).equals("OR")||
					tokenSet.get(i).get(0).equals(")") || tokenSet.get(i).get(0).equals("]") || tokenSet.get(i).get(0).equals(";") ||
					tokenSet.get(i).get(0).equals(",") || tokenSet.get(i).get(0).equals("}") || tokenSet.get(i).get(0).equals("=") ||
					tokenSet.get(i).get(0).equals("CAO") || tokenSet.get(i).get(0).equals("inc_dec")) {
				
				return true;
			}
			
		}
		return false;
	}
	

}