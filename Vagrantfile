# -*- mode: ruby -*-
# vi: set ft=ruby :

Vagrant.configure(2) do |config|

	config.vm.box = "pyama/windows-2012-R2"
	config.winrm.username = "vagrant"
	config.winrm.password = "vagrant"

	config.vm.network "forwarded_port", guest: 3389, host: 33389, auto_correct: true

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
			write-output "Downloading introcs.exe"
			Invoke-WebRequest 'http://introcs.cs.princeton.edu/java/windows/introcs.exe' -OutFile 'c:\vagrant\introcs.exe'
			write-output "Downloaded introcs.exe"
			}
		
		#use envar toggle to determine if we need to run introcs.exe	
		if(!($ENV:PROVISION_INTROCS)){
			write-output "Extracting introcs.exe"
			[Environment]::SetEnvironmentVariable("PROVISION_INTROCS","TRUE","MACHINE")
			start-process 'c:\vagrant\introcs.exe'
			write-output "Extracted introcs.exe"
			}
		~
	
	config.vm.provision "shell", inline: %q~
		#install a windows package manager
		$choco_present =  get-command choco -erroraction silently continue
		if(!($choco_present)){
			write-output "Installing Chocolatey"
			iwr https://chocolatey.org/install.ps1 -UseBasicParsing | iex
			write-output "Installed Chocolatey"
		}
			
		if(!($ENV:PROVISION_NOTEPADPLUSPLUS)){
			write-output "Installing notepadplusplus"
			[Environment]::SetEnvironmentVariable("PROVISION_NOTEPADPLUSPLUS","TRUE","MACHINE")
			choco install notepadplusplus -y --limit-output
			write-output "Installed notepadplusplus"
			}
	
		if(!($ENV:PROVISION_GIT)){
			write-output "Installing Git"
			[Environment]::SetEnvironmentVariable("PROVISION_GIT","TRUE","MACHINE")
			choco install git -y --limit-output
			write-output "Installed Git"
			}
		~
	
	config.vm.provision "shell", inline: %q~
		write-output "Performing registry modifications (setting system performance and UI customization for efficiency)"
		$RegistryModifications = get-childitem -path "c:\vagrant\Provision\Registry"
		foreach ($RegistryModification in $RegistryModifications){
			$RegistryFile = $RegistryModification.fullname
			reg import $RegistryFile
			}
		write-output "Performed registry modifications"
		~
end
