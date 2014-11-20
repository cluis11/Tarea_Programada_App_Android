class Usuarios 
 
 def initialize()
  File.open('usuarios.txt', 'a')
 end

 def usuarios_()
  @temp=""
  File.open('usuarios.txt','r') do |f|
   while line = f.gets
    @temp=@temp+line
    @temp=@temp+"#"
   end
  end
  @temp=@temp.gsub(/\s+/, "")
  @temp
 end

 def nuevo_usuario(user)
  @temp="" 
  user.each_char {|u|
   if u=="_"
    @temp=@temp+","
   else
    @temp=@temp+u
   end
  }
  File.open('usuarios.txt', 'a') do |f|
     f.puts @temp
  end
  user
 end
end
