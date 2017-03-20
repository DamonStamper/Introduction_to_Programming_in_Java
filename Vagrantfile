# -*- mode: ruby -*-
# vi: set ft=ruby :

Vagrant.configure(2) do |config|

  config.vm.box = "pyama/windows-2012-R2"
  
  # Settings specific to a windows box
  # config.vm.guest = :windows
  # config.vm.communicator = :winrm
  config.winrm.username = "vagrant"
  config.winrm.password = "vagrant"

  config.vm.network "forwarded_RDP_port", guest: 3389, host: 33389, auto_correct: true

  config.vm.provider "virtualbox" do |vb|
    vb.gui = false
	  vb.linked_clone = true
		vb.customize ["modifyvm", :id, "--clipboard", "bidirectional"]
		vb.memory = "2048"
		vb.cpus = 1
		vb.name = "Learn_Java"
  end
 
  config.vm.provision "shell", inline: %q~
	#Download introcs.exe if it doesn't exist. We don't use a feature toggle here because the c:\vagrant directory is shared between host/guest and is therefore persistant thus a VM specific toggle is insufficent.
	if (!(get-item 'c:\vagrant\introcs.exe')){
    Invoke-WebRequest 'http://introcs.cs.princeton.edu/java/windows/introcs.exe' -OutFile 'c:\vagrant\introcs.exe'
		}
	#use envar toggle to determine if we need to run introcs.exe	
	if(!($ENV:INTROCS)){
	  [Environment]::SetEnvironmentVariable("INTROCS","TRUE","MACHINE")
		start-process 'c:\vagrant\introcs.exe'
		}
  ~
  
end
